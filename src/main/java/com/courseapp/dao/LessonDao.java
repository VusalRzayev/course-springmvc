package com.courseapp.dao;

import com.courseapp.model.Lesson;

import java.util.List;

public interface LessonDao {
    List<Lesson> getLessons();
    boolean addLesson(Lesson lesson);
    boolean updateLesson(Lesson lesson);
    boolean deleteLesson(Lesson lesson);
    Lesson getLessonById(long id);
    long lessonCount();
}
