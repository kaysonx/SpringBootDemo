package me.utlight.dao;

import me.utlight.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDao {

    private final SqlSession sqlSession;

    public StudentDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Student> likeName(String name){
        return this.sqlSession.selectList("likeName", name);
    }

    public Student getById(int id){
        return this.sqlSession.selectOne("getById", id);
    }

    String getNameById(int id){
        return this.sqlSession.selectOne("getNameById", id);
    }
}
