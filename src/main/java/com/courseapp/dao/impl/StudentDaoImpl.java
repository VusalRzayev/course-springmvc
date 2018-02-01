package com.courseapp.dao.impl;

import com.courseapp.dao.StudentDao;
import com.courseapp.model.Lesson;
import com.courseapp.model.Student;
import com.courseapp.model.Teacher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {
        String sql="Select student.id,student.name,student.surname,student.address,student.dob," +
                "teacher.id as teacher_id,teacher.name as teacher_name,teacher.surname as " +
                "teacher_surname,lesson.name as lesson_name,lesson.id as lesson_id from student left join teacher on student.teacher_id=teacher.id left join lesson on teacher.lesson_id=lesson.id ";
        List<Student> students= jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student=new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setAddress(rs.getString("address"));
                student.setDob(rs.getDate("dob"));
                Teacher teacher=new Teacher();
                teacher.setId(rs.getLong("teacher_id"));
                teacher.setName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                student.setTeacher(teacher);
                Lesson lesson=new Lesson();
                lesson.setId(rs.getLong("lesson_id"));
                lesson.setName(rs.getString("lesson_name"));
                teacher.setLesson(lesson);
                return student;
            }
        });
        return students;
    }

    public boolean addStudent(Student student) {
        String sql="insert into student(name,surname,address,dob,teacher_id,code) values(?,?,?,?,?,?)";
        if(student.getTeacher()==null){
            student.setTeacher(new Teacher());
        }
        try{
            jdbcTemplate.update(sql,new Object[]{
                            student.getName(),student.getSurname(),
                            student.getAddress(),student.getDob(),student.getTeacher().getId(),student.getStudentCode()
                    }
            );
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateStudent(Student student) {
        String sql="update student s set s.name=?,s.surname=?,s.address=?,s.dob=?,s.teacher_id=? where s.id=? ";
        if(student.getTeacher()==null){
            student.setTeacher(new Teacher());
        }
        try {
            jdbcTemplate.update(sql, new Object[]{
                    student.getName(), student.getSurname(), student.getAddress(), student.getDob(),
                    student.getTeacher().getId(), student.getId()
            });
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean deleteStudent(Student student) {
        try{
            String sql="delete from student where id=?";
            jdbcTemplate.update(sql,new Object[]{student.getId()});
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Student getStudentById(long id) {
        String sql="select s.id,s.name,s.surname,s.dob,s.address,t.name as teacher_name,t.id as " +
                "teacher_id,t.surname as teacher_surname,l.id as lesson_id,l.name as lesson_name from student s left join teacher t on s.teacher_id=t.id" +
                " left join lesson l on t.lesson_id=l.id where s.id=?";
        try{
            Student student=jdbcTemplate.queryForObject(sql,new Object[]{id},new RowMapper<Student>(){
                @Override
                public Student mapRow(ResultSet rs, int i) throws SQLException {
                    Student student=new Student();
                    student.setId(rs.getLong("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setAddress(rs.getString("address"));
                    student.setDob(rs.getDate("dob"));
                    Teacher teacher=new Teacher();
                    teacher.setId(rs.getLong("teacher_id"));
                    teacher.setName(rs.getString("teacher_name"));
                    teacher.setSurname(rs.getString("teacher_surname"));
                    Lesson lesson=new Lesson();
                    lesson.setId(rs.getLong("lesson_id"));
                    lesson.setName(rs.getString("lesson_name"));
                    teacher.setLesson(lesson);
                    student.setTeacher(teacher);
                    return student;
                }
            });
            return student;
        }catch (EmptyResultDataAccessException e){
            return new Student();
        }

    }

    public long studentCount() {
        String sql="select count(*) from student";
        try{
            long count= jdbcTemplate.queryForObject(sql, new RowMapper<Long>() {
                @Override
                public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getLong("count(*)");
                }
            });
            return count;
        }catch (EmptyResultDataAccessException e){
            return 0;
        }

    }

}
