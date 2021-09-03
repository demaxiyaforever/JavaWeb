package com.xxxx.entity;

public class Book {
    private Integer bookId;
    private String bookName;
    private String bookPrice;
    private String bookAurthor;
    private String bookSale;
    private String bookRest;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAurthor() {
        return bookAurthor;
    }

    public void setBookAurthor(String bookAurthor) {
        this.bookAurthor = bookAurthor;
    }

    public String getBookSale() {
        return bookSale;
    }

    public void setBookSale(String bookSale) {
        this.bookSale = bookSale;
    }

    public String getBookRest() {
        return bookRest;
    }

    public void setBookRest(String bookRest) {
        this.bookRest = bookRest;
    }

    public Book(Integer bookId, String bookName, String bookPrice, String bookAurthor, String bookSale, String bookRest) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookAurthor = bookAurthor;
        this.bookSale = bookSale;
        this.bookRest = bookRest;
    }

    public Book() {
    }
}
