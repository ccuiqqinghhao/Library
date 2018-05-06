package com.example.demo.entity;

public class Log {
    private Integer id;
    private String uno;
    private String classifyNo;
    private String uBorrowDate;
    private Integer uReborrowTimes;
    private String returnDate;
    private String uExpectedReturnDate;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", uno='" + uno + '\'' +
                ", classifyNo='" + classifyNo + '\'' +
                ", uBorrowDate='" + uBorrowDate + '\'' +
                ", uReborrowTimes=" + uReborrowTimes +
                ", returnDate='" + returnDate + '\'' +
                ", uExpectedReturnDate='" + uExpectedReturnDate + '\'' +
                '}';
    }

    public String getuExpectedReturnDate() {
        return uExpectedReturnDate;
    }

    public void setuExpectedReturnDate(String uExpectedReturnDate) {
        this.uExpectedReturnDate = uExpectedReturnDate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getClassifyNo() {
        return classifyNo;
    }

    public void setClassifyNo(String classifyNo) {
        this.classifyNo = classifyNo;
    }

    public String getuBorrowDate() {
        return uBorrowDate;
    }

    public void setuBorrowDate(String uBorrowDate) {
        this.uBorrowDate = uBorrowDate;
    }

    public Integer getuReborrowTimes() {
        return uReborrowTimes;
    }

    public void setuReborrowTimes(Integer uReborrowTimes) {
        this.uReborrowTimes = uReborrowTimes;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
