package com.xxxx.mapper;

import com.xxxx.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookMapper {
    public Book queryBookByName(String bookName);

    public int saveBook(Book book);

    public List<Book> getBookListAll();

    public List<Book> getBookList(@Param("start") Integer start, @Param("stop") Integer stop);

    public void deleteBookByName(String bookName);

    public int updateBook(Book book);

}
