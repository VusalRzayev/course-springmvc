package com.courseapp.controller;

import com.courseapp.model.MailModel;
import com.courseapp.model.Student;
import com.courseapp.model.Teacher;
import com.courseapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    private TeacherService teacherService;
    private LessonService lessonService;
    private StudentService studentService;
    private MailService mailService;
    private UserService userService;

    @Autowired
    @Qualifier(value="teacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    @Qualifier(value="lessonService")
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    @Autowired
    @Qualifier(value="studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    @Qualifier(value = "mailService")
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //Methods

    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("main");
        modelAndView.addObject("message","Go");
        modelAndView.addObject("title","Course | Home");
        return modelAndView;

    }

    @RequestMapping(value="/studentList",method = RequestMethod.GET)
    public ModelAndView studentList(){
        ModelAndView modelAndView=new ModelAndView("student/studentList");
        modelAndView.addObject("title","Student List");
        List<Student> studentList=studentService.getStudents();
        modelAndView.addObject("students",studentList);
        return modelAndView;

    }

    @RequestMapping(value = "/add_new_student",method = RequestMethod.GET)
    public ModelAndView newStudent(){
        ModelAndView model=new ModelAndView("student/newStudent");
        model.addObject("title","New Student");
        List<Teacher> teachers=teacherService.getTeachers();
        model.addObject("teachers",teachers);
        return model;
    }


    @RequestMapping(value="/chat",method = RequestMethod.GET)
    public ModelAndView chat(){
        ModelAndView modelAndView=new ModelAndView("chat");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user =(User)authentication.getPrincipal();
        String username=user.getUsername();
        String password=user.getPassword();
        com.courseapp.model.User currentUserDetails=userService.getUser(username,password);
        int currentId=currentUserDetails.getId();
        modelAndView.addObject("currentId",currentId);
        return modelAndView;
    }






}
