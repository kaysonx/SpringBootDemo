package me.utlight.demo1;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //In IntelliJ IDEA, building the project (Build → Make Project) will automatically restart.

    @RequestMapping
    public String hello(){
        return "Hello,the Spring Boot!";
    }

    @RequestMapping("/param")
    public Map<String, String> getInfo(@RequestParam String paramValue){
        Map<String, String> map = new HashMap<>();
        map.put("paramValue",paramValue);
        return map;
    }

    @RequestMapping("/list")
    public List<Map<String, String>> getList(){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<>();
            map.put("name","name:"+i);
            list.add(map);
        }

        return list;
    }

    @RequestMapping("/map")
    public HttpEntity<Map<String, String>> getMap(){
        Map<String, String> map = new HashMap<>();
        map.put("key","value");
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);

    }

}