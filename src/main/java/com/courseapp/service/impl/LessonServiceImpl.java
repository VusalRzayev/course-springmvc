package com.courseapp.service.impl;

import com.courseapp.dao.LessonDao;
import com.courseapp.model.Lesson;
import com.courseapp.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {

    private LessonDao lessonDao;


    public void setLessonDao(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public List<Lesson> getLessons() {
        return lessonDao.getLessons();
    }

    @Override
    public boolean addLesson(Lesson lesson) {
        return lessonDao.addLesson(lesson);
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return lessonDao.updateLesson(lesson);
    }

    @Override
    public boolean deleteLesson(Lesson lesson) {
        return lessonDao.deleteLesson(lesson);
    }

    @Override
    public Lesson getLessonById(long id) {
        return lessonDao.getLessonById(id);
    }

    @Override
    public long lessonCount() {
        return lessonDao.lessonCount();
    }
}
