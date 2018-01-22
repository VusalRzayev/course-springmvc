package com.courseapp.dao.impl;

import com.courseapp.dao.LessonDao;
import com.courseapp.model.Lesson;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LessonDaoImpl implements LessonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Lesson> getLessons() {
        return null;
    }

    @Override
    public boolean addLesson(Lesson lesson) {
        return false;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return false;
    }

    @Override
    public boolean deleteLesson(Lesson lesson) {
        return false;
    }

    @Override
    public Lesson getLessonById(long id) {
        return null;
    }

    @Override
    public long lessonCount() {
        return 0;
    }
}
