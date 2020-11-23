package com.yyh.controller;

import com.yyh.dao.UserDao;
import com.yyh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("findAll")
    @ResponseBody
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.setViewName("user/user");
        modelAndView.addObject("users", userDao.findAll());
        return modelAndView;
    }

    @PostMapping("insert")
    @ResponseBody
    public void insert(@RequestBody User user) {
        userDao.save(user);
    }

    @RequestMapping("delete/{id}")
    public ModelAndView delete(@PathVariable String id, ModelAndView modelAndView) {
        userDao.deleteById(id);
        modelAndView.setViewName("user/user");
        modelAndView.addObject("users", userDao.findAll());
        return modelAndView;
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    public User findById(@PathVariable String id) {
        return userDao.findUserById(id);
    }

    @GetMapping("findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userDao.findByUsername(username);
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest request) {
        User vo = userDao.findByUsername(user.getUsername());
        if (vo != null)//用户存在
            if (user.getPassword().equals(vo.getPassword()))//密码正确
                return "loginSuccess";
            else
                return "passwordError";
        else
            return "userNotFound";
    }
}
