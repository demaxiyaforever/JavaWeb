package com.xxxx.test;

import com.xxxx.entity.Book;
import com.xxxx.mapper.BookMapper;
import com.xxxx.until.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void getBookList() {
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookmapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList=bookmapper.getBookListAll();
        for(Book book:bookList){
            System.out.println(book);
        }
        sqlSession.close();

    }
    public void bookdelete(String bookName) {
        SqlSession sqlSession =GetSqlSession.createSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book =bookMapper.queryBookByName(bookName);
        if(book!=null){
            bookMapper.deleteBookByName(bookName);
        }
        sqlSession.close();
    }

    @Test
    public void delelteTest() {
         bookdelete("123");
    }

    @Test
    public void bookListget(){
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        BookMapper bookmapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList=bookmapper.getBookList(0,1);
        for(Book book:bookList){
            System.out.println(book);
        }
        sqlSession.close();

    }
}