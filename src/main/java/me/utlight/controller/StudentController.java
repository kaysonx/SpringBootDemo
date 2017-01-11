package me.utlight.controller;

import com.github.pagehelper.PageHelper;
import me.utlight.dao.StudentDao;
import me.utlight.entity.Student;
import me.utlight.mapper.StudentMaper;
import me.utlight.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    //1.This is the first way.
    //@Autowired
    //private StudentDao studentDao;
    //
    //@Autowired
    //private StudentMaper studentMaper;

    //2.This is the secong way.
    //the demo:https://github.com/mybatis/spring-boot-starter/tree/master/mybatis-spring-boot-samples/mybatis-spring-boot-sample-xml
    private final StudentDao studentDao;
    private final StudentMaper studentMaper;

    public StudentController(StudentDao studentDao, StudentMaper studentMaper) {
        this.studentDao = studentDao;
        this.studentMaper = studentMaper;
    }


    @ResponseBody
    @RequestMapping("/list")
    public List<Student> getList(){
        logger.info("get the student list by jdbc.....");
        return service.getStudents();
    }

    @ResponseBody
    @RequestMapping("/list2")
    public List<Student> likeName(@RequestParam("name") String name){
        return studentMaper.likeName(name);
    }

    @ResponseBody
    @RequestMapping("/list3")
    public List<Student> likeName2(@RequestParam("name") String name){
        return studentDao.likeName(name);
    }

    @ResponseBody
    @RequestMapping("/list4")
    public List<Student> likeName3(@RequestParam("name") String name){
        PageHelper.startPage(1,2);
        return studentDao.likeName(name);
    }

}
