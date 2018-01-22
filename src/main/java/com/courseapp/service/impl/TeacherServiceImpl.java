package com.courseapp.service.impl;

import com.courseapp.dao.TeacherDao;
import com.courseapp.model.Teacher;
import com.courseapp.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherDao.getTeachers();
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        return teacherDao.deleteTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public long teacherCount() {
        return teacherDao.teacherCount();
    }
}
