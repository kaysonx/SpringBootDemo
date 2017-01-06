package me.utlight.controller;

import me.utlight.entity.Student;
import me.utlight.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    @ResponseBody
    @RequestMapping("/list")
    public List<Student> getList(){
        logger.info("get the student list by jdbc.....");
        return service.getStudents();
    }
}
