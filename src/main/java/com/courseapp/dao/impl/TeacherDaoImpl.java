package com.courseapp.dao.impl;

import com.courseapp.dao.TeacherDao;
import com.courseapp.model.Lesson;
import com.courseapp.model.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Teacher> getTeachers() {
        String sql="select t.id,t.name as teacher_name,t.surname as teacher_surname,l.name as lesson_name from teacher t join lesson l on t.lesson_id=l.id";
        List<Teacher> teachers = jdbcTemplate.query(sql, new RowMapper<Teacher>() {
            @Override
            public Teacher mapRow(ResultSet rs, int i) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("id"));
                teacher.setName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                Lesson lesson = new Lesson();
                lesson.setName(rs.getString("lesson_name"));
                teacher.setLesson(lesson);
                return teacher;
            }
        });
        return teachers;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        return false;
    }

    @Override
    public Teacher getTeacherById(long id) {
        return null;
    }

    @Override
    public long teacherCount() {
        return 0;
    }
}
