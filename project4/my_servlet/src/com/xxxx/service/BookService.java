package com.xxxx.service;

import com.xxxx.entity.Book;
import com.xxxx.entity.vo.BookPage;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.BookMapper;
import com.xxxx.until.GetSqlSession;
import com.xxxx.until.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookService {
    //    List<Book> cbookList =new ArrayList<Book>();
//    boolean result=false;
    public MessageModel BookSubmit(String bookName, String bookPrice, String bookAurthor, String bookSale, String bookRest) {
        MessageModel messageModel = new MessageModel();
        Book B = new Book();
        B.setBookName(bookName);
        B.setBookPrice(bookPrice);
        B.setBookAurthor(bookAurthor);
        B.setBookSale(bookSale);
        B.setBookRest(bookRest);
        messageModel.setObject(B);

        if (StringUtil.isEmpty(bookName) || StringUtil.isEmpty(bookPrice) || StringUtil.isEmpty(bookAurthor) || StringUtil.isEmpty(bookSale) || StringUtil.isEmpty(bookRest)) {
            messageModel.setCode(0);
            messageModel.setMsg("不许为空");
            return messageModel;
        }
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.queryBookByName(bookName);

        if (book != null) {
            messageModel.setCode(0);
            messageModel.setMsg("书本重复");
            return messageModel;
        }
        bookMapper.saveBook(B);
        sqlSession.commit();
        sqlSession.close();
        return messageModel;
    }
//    public List<Book> getBookList(){
//        SqlSession sqlSession = GetSqlSession.createSqlSession();
//        BookMapper bookmapper = sqlSession.getMapper(BookMapper.class);
//        List<Book> bookList=bookmapper.getBookList();
//        sqlSession.close();
//        return bookList;
//
//    }

    public void bookdelete(String bookName) {
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.queryBookByName(bookName);
        if (book != null) {
            bookMapper.deleteBookByName(bookName);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public MessageModel bookupdate(String bookName, String bookPrice, String bookAurthor, String bookSale, String bookRest) {
        MessageModel messageModel = new MessageModel();
        Book B = new Book();
        B.setBookName(bookName);
        B.setBookPrice(bookPrice);
        B.setBookAurthor(bookAurthor);
        B.setBookSale(bookSale);
        B.setBookRest(bookRest);
        messageModel.setObject(B);

        if (StringUtil.isEmpty(bookName) || StringUtil.isEmpty(bookPrice) || StringUtil.isEmpty(bookAurthor) || StringUtil.isEmpty(bookSale) || StringUtil.isEmpty(bookRest)) {
            messageModel.setCode(0);
            messageModel.setMsg("不许为空");
            return messageModel;
        }
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.updateBook(B);
        sqlSession.commit();
        sqlSession.close();
        return messageModel;
    }

    public MessageModel getBookList(Integer currentPage) {
        MessageModel messageModel =new MessageModel();
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookmapper = sqlSession.getMapper(BookMapper.class);
        List<Book> AllbookList = bookmapper.getBookListAll();
        Integer listsize = AllbookList.size();
        int start = (currentPage - 1) * 5+1;
        int stop = 0;
        if ((start + 4) <= listsize) {
            stop=5;
        } else {
            stop = listsize -start+1;
        }
        if(currentPage>(listsize - 1) / 5 + 1){
            messageModel.setCode(0);
            messageModel.setMsg("没有这一页了");
            return messageModel;
        }
        if(currentPage<1){
            messageModel.setCode(0);
            messageModel.setMsg("没有这一页了");
            return messageModel;
        }
        List<Book> bookList = bookmapper.getBookList(start-1, stop);
        sqlSession.close();
        Integer totalPage = (listsize - 1) / 5 + 1;
        BookPage<Book> bookPage = new BookPage<Book>();
        bookPage.setPageSize(5);
        bookPage.setTotalNum(listsize);
        bookPage.setTotalPage(totalPage);
        bookPage.setCurrentPage(currentPage);
        bookPage.setList(bookList);
        messageModel.setObject(bookPage);
        messageModel.setMsg(" ");
        return messageModel;

    }
//    public MessageModel PageList(BookPage<Book> bookPage,Integer Page){
//        MessageModel messageModel =new MessageModel();
//        messageModel.setObject(bookPage);
//        if(Page>bookPage.getTotalPage()){
//            messageModel.setCode(0);
//            messageModel.setMsg("没有这一页了");
//            return messageModel;
//        }
//        if(Page<1){
//            messageModel.setCode(0);
//            messageModel.setMsg("没有这一页了");
//            return messageModel;
//        }
//        messageModel.setMsg(" ");
//        return messageModel;
//    }
}
