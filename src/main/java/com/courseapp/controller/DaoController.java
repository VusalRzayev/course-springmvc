package com.courseapp.controller;

import com.courseapp.functions.Functions;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class DaoController {

    private TeacherService teacherService;
    private LessonService lessonService;
    private StudentService studentService;
    private MailService mailService;


    @Autowired
    @Qualifier(value = "teacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    @Qualifier(value="lessonService")
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    @Qualifier(value="mailService")
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestParam("name")String name,@RequestParam("surname")String surname,
                             @RequestParam("dob")String dob,@RequestParam("email")String email,@RequestParam("teacherId")Long teacherId)throws Exception{
        String result=Functions.validStudentParams(name,surname,email,dob,teacherId);
        if(result.equals("Ok")){
        Student student=new Student();
        student.setName(name);
        student.setSurname(surname);
        Teacher teacher=new Teacher();
        teacher.setId(teacherId);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm/dd/yyyy");
        Date studentDate=simpleDateFormat.parse(dob);
        student.setTeacher(teacher);
        student.setDob(studentDate);
        student.setAddress(email);
        if(!email.isEmpty()) {
        Random random = new Random();
        int code = random.nextInt(9999);
        String studentCode = String.valueOf(code);
        student.setStudentCode(studentCode);
        boolean r = studentService.addStudent(student);
        if (r) {
         MailModel mailModel = new MailModel();
         mailModel.setSubject("From Course App Code for Registration");
         mailModel.setTo(email);
         mailModel.setFrom("Course");
         mailModel.setContent(studentCode);
         mailService.sendMessage(mailModel);
         return "Student Added and EMail Sended";
         } else {
          return "Error";
         }
        }else {
            boolean r = studentService.addStudent(student);
            if (r) {
                return "Student Added";
            } else {
                return "Error";
            }

        }
        }else {
            return result;
        }

        }


     @RequestMapping(value = "/getStudentById/{id}",method = RequestMethod.GET)
     public ModelAndView getStudentById(@PathVariable("id") long id){
        ModelAndView model=new ModelAndView("student/editStudent");
        Student student=studentService.getStudentById(id);
        model.addObject("student",student);
         List<Teacher> teachers=teacherService.getTeachers();
         model.addObject("teachers",teachers);
        return model;

     }

     @RequestMapping(value="/editStudent",method = RequestMethod.POST)
     @ResponseBody
     public String editStudent(@RequestParam("name")String name,@RequestParam("surname")String surname,
                                     @RequestParam("email")String email,@RequestParam("teacherId")long teacherId,
                               @RequestParam("id")long id){

        String result=Functions.validStudentParams(name,surname,email,"studentDob",teacherId);
        if(result.equals("Ok")){
            Student student=studentService.getStudentById(id);
            if(student.getAddress().isEmpty()||email.isEmpty()){
                student.setName(name);
                student.setSurname(surname);
                student.setId(id);
                Teacher teacher=new Teacher();
                teacher.setId(teacherId);
                student.setTeacher(teacher);
                boolean r=studentService.updateStudent(student);
                if(r){
                    return "Student Edited";
                }else {
                    return "Error";
                }
            }else {
                return null;
            }
        }else {
            return result;
        }
     }
}
