package com.example.demo.entity;

public class Book {
    private String classifyNo;
    private String bname;
    private String bwriter;
    private String bpubAdr;
    private String bpubDate;
    private Integer bprice;
    private String btype;
    private Integer btotalNum;

    public String getBpubDate() {
        return bpubDate;
    }

    public void setBpubDate(String bpubDate) {
        this.bpubDate = bpubDate;
    }

    private Integer bborrowedNum;

    public String getClassifyNo() {
        return classifyNo;
    }

    public void setClassifyNo(String classifyNo) {
        this.classifyNo = classifyNo;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public String getBpubAdr() {
        return bpubAdr;
    }

    public void setBpubAdr(String bpubAdr) {
        this.bpubAdr = bpubAdr;
    }

    public Integer getBprice() {
        return bprice;
    }

    public void setBprice(Integer bprice) {
        this.bprice = bprice;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Integer getBtotalNum() {
        return btotalNum;
    }

    public void setBtotalNum(Integer btotalNum) {
        this.btotalNum = btotalNum;
    }

    public Integer getBborrowedNum() {
        return bborrowedNum;
    }

    public void setBborrowedNum(Integer bborrowedNum) {
        this.bborrowedNum = bborrowedNum;
    }
}
