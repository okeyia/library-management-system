package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //    controller 调用service层
    private final BookService bookService;

    public BookController(@Qualifier("bookServiceImpl") BookService bookService) {
        this.bookService = bookService;
    }

    //    查询所有的书籍, 并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.selectALLBook();
        model.addAttribute("list", books);
        return "/allBook";
    }

    //    跳转到增加数据页面
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    //    添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println();
        bookService.addBook(books);
        //  重定向到我们的@RequestMapping("allBook")
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdateBook(int id, Model model) {
        Books books = bookService.selectBookById(id);
        // 让jsp那边拿到数据
        model.addAttribute("books", books);

        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("BookServiceImpl: updateBook=>" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //    查询书籍
    @RequestMapping("selectBook")
    public String selectBook(String bookName, Model model) {

        // 书籍名称查询一本书
        Books book = bookService.selectBookByName(bookName);
        List<Books> list = new ArrayList<>();
        list.add(book);
        model.addAttribute("list",list);
        return "allBook";

    }
}
