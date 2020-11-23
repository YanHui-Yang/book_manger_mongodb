package com.yyh.controller;

import com.yyh.dao.BookDao;
import com.yyh.dao.BorrowDao;
import com.yyh.dao.RetDao;
import com.yyh.dao.UserDao;
import com.yyh.pojo.Book;
import com.yyh.pojo.BorrowBook;
import com.yyh.pojo.RetBook;
import com.yyh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("page")
public class PageController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private RetDao retDao;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("left")
    public String left() {
        return "left";
    }

    @GetMapping("right")
    public String right() {
        return "right";
    }

    @GetMapping("top")
    public String top() {
        return "top";
    }

    @GetMapping("addBook")
    public String addBook() {
        return "book/add";
    }

    @GetMapping("editBook/{id}")
    public String editBook(@PathVariable String id, HttpServletRequest request) {
        Book book = bookDao.findBookById(id);
        request.setAttribute("book", book);
        return "book/edit";
    }

    @GetMapping("addUser")
    public String addUser() {
        return "user/add";
    }

    @GetMapping("editUser/{id}")
    public String editUser(@PathVariable String id, HttpServletRequest request) {
        User user = userDao.findUserById(id);
        request.setAttribute("user", user);
        return "user/edit";
    }

    @GetMapping("addBorrow")
    public String addBorrow() {
        return "borrow/add";
    }

    @GetMapping("editBorrow/{id}")
    public String editBorrow(@PathVariable String id, HttpServletRequest request) {
        BorrowBook borrowBook = borrowDao.findBorrowBookById(id);
        request.setAttribute("borrow", borrowBook);
        return "borrow/edit";
    }

    @GetMapping("addRet")
    public String addRet() {
        return "ret/add";
    }

    @GetMapping("editRet/{id}")
    public String editRet(@PathVariable String id, HttpServletRequest request) {
        RetBook retBook = retDao.findRetBookById(id);
        request.setAttribute("ret", retBook);
        return "ret/edit";
    }
}
