package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookMapper {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBook(@Param("bookid") int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books selectBookById(int id);

    //查询所有的书
    List<Books> selectAllBook();

    //    查询书籍
    Books selectBookByName(String bookName);
}
