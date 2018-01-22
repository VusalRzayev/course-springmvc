package com.courseapp.dao;

import com.courseapp.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
    Student getStudentById(long id);
    long studentCount();
}
