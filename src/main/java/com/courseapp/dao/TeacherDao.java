package com.courseapp.dao;

import com.courseapp.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeachers();
    boolean addTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    long teacherCount();
}
