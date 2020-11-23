package com.yyh.controller;

import com.yyh.dao.BorrowDao;
import com.yyh.pojo.BorrowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("borrow")
public class BorrowBookController {

    @Autowired
    private BorrowDao borrowDao;

    @GetMapping("findAll")
    @ResponseBody
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("borrow/borrow");
        modelAndView.addObject("borrows", borrowDao.findAll());
        return modelAndView;
    }

    @PostMapping("insert")
    @ResponseBody
    public void insert(@RequestBody BorrowBook borrowBook) {
        borrowDao.save(borrowBook);
    }

    @RequestMapping("delete/{id}")
    public ModelAndView delete(@PathVariable String id, ModelAndView modelAndView) {
        borrowDao.deleteById(id);
        modelAndView.setViewName("borrow/borrow");
        modelAndView.addObject("borrows", borrowDao.findAll());
        return modelAndView;
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public BorrowBook findById(@PathVariable String id) {
        return borrowDao.findBorrowBookById(id);
    }
}
