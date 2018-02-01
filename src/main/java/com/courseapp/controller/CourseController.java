package com.courseapp.controller;

import com.courseapp.model.MailModel;
import com.courseapp.model.Student;
import com.courseapp.model.Teacher;
import com.courseapp.service.LessonService;
import com.courseapp.service.MailService;
import com.courseapp.service.StudentService;
import com.courseapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


    @RequestMapping(value="/sendEmail",method=RequestMethod.GET)
    @ResponseBody
    public  String getPerson(){
        MailModel mailModel=new MailModel();
        mailModel.setFrom("CourseApp");
        mailModel.setTo("e@mail.com");
        mailModel.setContent("1234");
        mailModel.setSubject("Code for Registration");
        mailService.sendMessage(mailModel);
        return mailService.toString();
    }



}
