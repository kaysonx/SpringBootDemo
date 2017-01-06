package me.utlight;

import me.utlight.servlet.MyServlet1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringBootDemoApplication {

	//many spring-boot default configuration can be changed this way, and another is the property file.
	//@Bean
    //public ServletRegistrationBean dispatcherRegistrationBean(DispatcherServlet dispatcherServlet){
    //   ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
    //   //servlet dispatcherservlet was not registered (possibly already registered )
    //   //use this must add the below code or it doesn't work. but also the httpsessionlistener and the jsp do not word too.
    //   servletRegistrationBean.addUrlMappings("/*");
    //   servletRegistrationBean.addUrlMappings("*.jsp");
    //   return servletRegistrationBean;
    //}

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet1(),"/xs/*");
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
