package com.courseapp.service.impl;

import com.courseapp.dao.StudentDao;
import com.courseapp.model.Student;
import com.courseapp.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(Student student) {
        return studentDao.deleteStudent(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public long studentCount() {
        return studentDao.studentCount();
    }
}
