package ru.volnenko.se;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.volnenko.se.controller.Bootstrap;

@Configuration
@ComponentScan(basePackages = "ru.volnenko")
public class App {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	
        final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.start();
    }

}
