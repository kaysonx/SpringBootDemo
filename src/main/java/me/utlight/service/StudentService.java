package me.utlight.service;

import me.utlight.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudents(){
        String sql = "SELECT Id,Name,Age,Score_Sum,Score_Avg FROM test.Student;";
        return (List<Student>)jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("Id"));
                student.setName(rs.getString("Name"));
                student.setAvgScore(rs.getFloat("Score_Avg"));
                student.setSumScore(rs.getFloat("Score_Sum"));
                student.setAge(rs.getInt("Age"));

                return student;
            }
        });
    }
}
