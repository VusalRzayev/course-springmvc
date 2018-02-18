package com.courseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",required = false)String error){
        ModelAndView model=new ModelAndView("login");
        if(error!=null){
            String message="Username or password is incorrect";
            model.addObject("message",message);
        }
        return model;
    }

    @RequestMapping(value = "/403",method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        String title="403";
        String error="Access Denied";
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("title",title);
        modelAndView.addObject("message",error);
        return modelAndView;
    }
}
