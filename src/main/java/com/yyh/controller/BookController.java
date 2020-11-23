package com.yyh.controller;

import com.yyh.dao.BookDao;
import com.yyh.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("findAll")
    @ResponseBody
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("book/book");
        modelAndView.addObject("books", bookDao.findAll());
        return modelAndView;
    }

    @PostMapping("insert")
    @ResponseBody
    public void insert(@RequestBody Book book) {
        bookDao.save(book);
    }

    @RequestMapping("delete/{id}")
    public ModelAndView delete(@PathVariable String id, ModelAndView modelAndView) {
        bookDao.deleteById(id);
        modelAndView.setViewName("book/book");
        modelAndView.addObject("books", bookDao.findAll());
        return modelAndView;
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public Book findById(@PathVariable String id) {
        return bookDao.findBookById(id);
    }
}
