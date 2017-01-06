package me.utlight.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class JspController {

    //spring-boot-jsp-demo:
    //https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-web-jsp

    @Value("${application.testname}")
    private String propertyValue = "defaultValue";

    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        model.put("time", LocalDate.now());
        model.put("message", this.propertyValue);
        return "index";
    }

    @RequestMapping("page1")
    public ModelAndView page1(){
        ModelAndView modelAndView = new ModelAndView("page/page1");
        modelAndView.addObject("content", this.propertyValue);
        return  modelAndView;
    }

    @RequestMapping("page2")
    public String page2(Model model){
        model.addAttribute("content",this.propertyValue + "第二种jsp页面传值方式");
        return  "page/page1";
    }

}
