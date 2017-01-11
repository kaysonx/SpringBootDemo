package me.utlight.mapper;

import me.utlight.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMaper{

    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);
}
