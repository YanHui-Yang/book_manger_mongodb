package com.yyh.controller;

import com.yyh.dao.BorrowDao;
import com.yyh.dao.RetDao;
import com.yyh.pojo.BorrowBook;
import com.yyh.pojo.RetBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ret")
public class RetController {

    @Autowired
    private RetDao retDao;

    @GetMapping("findAll")
    @ResponseBody
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("ret/ret");
        modelAndView.addObject("rets", retDao.findAll());
        return modelAndView;
    }

    @PostMapping("insert")
    @ResponseBody
    public void insert(@RequestBody RetBook retBook) {
        retDao.save(retBook);
    }

    @RequestMapping("delete/{id}")
    public ModelAndView delete(@PathVariable String id, ModelAndView modelAndView) {
        retDao.deleteById(id);
        modelAndView.setViewName("ret/ret");
        modelAndView.addObject("rets", retDao.findAll());
        return modelAndView;
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public RetBook findById(@PathVariable String id) {
        return retDao.findRetBookById(id);
    }
}
