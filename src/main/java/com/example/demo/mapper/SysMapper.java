package com.example.demo.mapper;
import com.example.demo.entity.Book;
import com.example.demo.entity.Sys;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;


public interface SysMapper {

    /**
     * 管理员登录(还未实现)
     * @param sys
     * @return
     */

    @Select("select * from sys where Sno=#{sno} and Spwd=#{spwd}")
    Sys login(Sys sys);

    /**
     * 管理员查询所有用户
     * @return
     */
    @Select("select Uno,Uname,Usex,Ubirth,Uphone,UPosition from User")
    List<User> selectAllUser();

    /**
     * 根据Uno查询User
     * @param user
     * @return
     */
    @Select("select Uno,Uname,Usex,Ubirth,Uphone,UPosition from User where Uno =#{uno}")
    List<User> selectUserByUno(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("update user set Uname =#{uname},Usex=#{usex},Ubirth=#{ubirth},Uphone=#{uphone},UPosition=#{uposition} where Uno=#{uno}")
    Integer updateUser(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("insert into user(Uno,Upwd,Uname,Usex,Ubirth,Uphone,UPosition)values(#{uno},#{uno},#{uname},#{usex},#{ubirth},#{uphone},#{uposition})")
    Integer insertUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    @Delete("delete from user where Uno=#{uno}")
    Integer deleteUser(User user);


    /**
     * 管理员检索图书
     * 模糊查询
     * @param book
     * @return
     */
    @Select("select * from Book where bname like '%${bname}%'")
    List<Book> selectBookByBname(Book book);

    /**
     * 根据CLassifyNo查询图书
     * @param book
     * @return
     */
    @Select("select * from book where ClassifyNo=#{classifyNo}")
    List<Book> selectBookByClassifyNo(Book book);

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    @Update("update book set Bname=#{bname},Bwriter=#{bwriter},BpubAdr=#{bpubAdr},BpubDate=#{bpubDate},Bprice=#{bprice},Btype=#{btype} where ClassifyNo=#{classifyNo}")
    Integer updateBook(Book book);

    /**
     * 删除图书
     * @param book
     */
    @Delete("delete from book where ClassifyNo=#{classifyNo}")
    Integer deleteBook(Book book);


    /**
     * 添加图书
     * @param book
     * @return
     */
    @Insert("insert into book (ClassifyNo,Bname,Bwriter,BpubAdr,BpubDate,Bprice,Btype,BtotalNum)values(#{classifyNo},#{bname},#{bwriter},#{bpubAdr},#{bpubDate},#{bprice},#{btype},#{btotalNum})")
    Integer insertBook(Book book);

    /**
     * 如果图书编号已经存在,变更总数量
     * @param book
     * @return
     */
    @Update("update book set BtotalNum=BtotalNum+1 where ClassifyNo=#{classifyNo}")
    Integer updateBookTotalNum(Book book);


    /**图书借阅部分开始**/

    /**
     * 检查是否借过此书
     * @param uno
     * @param classifyNo
     * @return
     */
    @Select("select count(*) from userbook where Uno=#{uno} and ClassifyNo=#{classifyNo}")
    Integer selectIsBorrowedThisBook(@Param("uno") String uno, @Param("classifyNo") String classifyNo);
    /**
     * 添加到借阅信息表
     * @param uno
     * @param classifyNo
     * @return
     */
    @Insert("insert into userbook (Uno,ClassifyNo,UBorrowDate,UExpectedReturnDate)values(#{uno},#{classifyNo},sysDate(),date_add(now(),interval 1 MONTH))")
    Integer borrowBook(@Param("uno") String uno, @Param("classifyNo") String classifyNo);

    /**
     * 更新图书已借出数量
     * @param book
     * @return
     */
    @Update("update book set BborrowedNum=BborrowedNum+1 where ClassifyNo=#{classifyNo}")
    Integer updateBookBorrowedNumWhenBorrow(Book book);

    /**
     *更新rdeleted表格
     * @param uno
     * @param classifyNo
     * @return
     */
    @Insert("insert into rdeleted (Uno,ClassifyNo,UBorrowDate)values(#{uno},#{classifyNo},sysDate())")
    Integer insertRdeleted(@Param("uno") String uno, @Param("classifyNo") String classifyNo);

    /**图书借阅部分结束**/





    /**续借操作开始**/

    /**
     * 查询是否续借过
     * @param uno
     * @param classifyNo
     * @return
     */
    @Select("select UReborrowTimes from userbook where Uno=#{uno} and ClassifyNo=#{classifyNo}")
    Integer selectUReborrowTimesFromUserbook(@Param("uno") String uno, @Param("classifyNo") String classifyNo);
    /**
     * 更新userbook表中UReborrowTimes和UExpectedReturnDate
     * @param uno
     * @param classifyNo
     * @return
     */
    @Update("update userbook set UReborrowTimes=UReborrowTimes+1,UExpectedReturnDate=date_add(UExpectedReturnDate,interval 1 MONTH) where Uno=#{uno} and ClassifyNo=#{classifyNo}")
    Integer updateUserBookUReborrowTimesAndUExpectedReturnDate(@Param("uno") String uno, @Param("classifyNo") String classifyNo);

    /**
     * 更新rdeleted表中UReborrowTimes
     * @param uno
     * @param classifyNo
     * @return
     */
    @Update("update rdeleted set UReborrowTimes=UReborrowTimes+1 where Uno=#{uno} and ClassifyNo=#{classifyNo} and ReturnDate is null")
    Integer updateRdeletedUReborrowTimes(@Param("uno") String uno, @Param("classifyNo") String classifyNo);
    /**续借操作结束**/



    /**图书归还部分开始*/

    /**
     * 更新rdeleted表中归还时间
     * @param uno
     * @param classifyNo
     * @return
     */
    @Update("update rdeleted set ReturnDate=sysDate() where Uno=#{uno} and ClassifyNo=#{classifyNo} and ReturnDate is null")
    Integer updateRdeletedReturnTime(@Param("uno") String uno, @Param("classifyNo") String classifyNo);

    /**
     * 更新book表中借出数量
     * @param book
     * @return
     */
    @Update("update book set BborrowedNum=BborrowedNum-1 where ClassifyNo=#{classifyNo}")
    Integer updateBookBorrowedNumWhenReturn(Book book);

    /**
     * 删除userbook中的值
     * @param uno
     * @param classifyNo
     * @return
     */
    @Delete("delete from userbook where Uno=#{uno} and ClassifyNo=#{classifyNo}")
    Integer deleteUserBook(@Param("uno") String uno, @Param("classifyNo") String classifyNo);
    /**图书归还部分结束*/




}
