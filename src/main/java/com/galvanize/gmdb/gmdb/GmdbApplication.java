package com.galvanize.gmdb.gmdb;

import com.galvanize.gmdb.gmdb.exception.UserAlreadyExistsException;
import com.galvanize.gmdb.gmdb.model.UserDto;
import com.galvanize.gmdb.gmdb.service.UserDetailsService;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GmdbApplication {

    @Autowired
    UserDetailsService service;

    public static void main(String[] args) {

       ConfigurableApplicationContext context =  SpringApplication.run(GmdbApplication.class, args);
       GmdbApplication application = context.getBean(GmdbApplication.class);
       application.process(application);
    }

    public static void process(GmdbApplication application) {

        UserDto user1 = new UserDto();
        UserDto user2 = new UserDto();

        user1.setUserName("username1");
        user1.setFirstName("Homer");
        user1.setLastName("Simpson");
        user1.setEmail("homer.simpson@gmail.com");
        user1.setRole("USER");
        user1.setPassword("password1");

        user2.setUserName("username2");
        user2.setFirstName("Marge");
        user2.setLastName("Simpson");
        user2.setEmail("marge.simpson@gmail.com");
        user2.setRole("ADMIN");
        user2.setPassword("password1");

        UserDetailsService service = application.service;

        try {
            service.registerNewUserAccount(user1);
            service.registerNewUserAccount(user2);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }

    }

}
