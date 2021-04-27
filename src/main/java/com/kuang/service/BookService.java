package com.kuang.service;

import com.kuang.pojo.Books;

import java.util.List;

public interface BookService {
    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books selectBookById(int id);

    //查询所有的书
    List<Books> selectALLBook();


    Books selectBookByName(String bookName);
}
