package com.netcracker.accountingofstudents.Students.Repository;

import com.netcracker.accountingofstudents.Students.Students;
import com.netcracker.accountingofstudents.Students.Mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Component
public class StudentsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Students getStudentsById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * from students where id = ?", new StudentsMapper(), id);
    }

    public List<Map<String, Object>> getStudentsPlain() {
        return jdbcTemplate.queryForList("SELECT * from students");
    }

    public List<Students> getStudents() {
        return jdbcTemplate.query("SELECT * from students", new StudentsMapper());
    }

    public void updateStudents(Students students) {
        String query = "UPDATE Students SET fullName = ?, group = ?";
        jdbcTemplate.update(query, students.getFullName(), students.getGroup());
    }

    public Students insertStudents(Students students) {
        String query = "INSERT INTO Students (full_name, group ) VALUES (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, students.getFullName());
            preparedStatement.setString(2, students.getGroup());
            return preparedStatement;
        }, keyHolder);
        return getStudentsById(keyHolder.getKey().intValue());
    }

//      public void deleteStudentById(Integer id) {
//        return jdbcTemplate.queryForObject("DELETE FROM students where id = ?");
//    }
}
