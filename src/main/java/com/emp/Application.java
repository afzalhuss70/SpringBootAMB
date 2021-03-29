package com.emp;

import com.emp.dao.UserDao;
import com.emp.model.Employee;
import com.emp.model.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(UserDao userDao){
        return args -> {
            Employee user1 = new Employee();
            user1.setFirstName("Fzl");
            user1.setLastName("Hsn");
            user1.setSalary(12345);
            user1.setAge(23);
            user1.setUsername("abc");
            user1.setPassword(passwordEncoder.encode("abcde"));
            userDao.save(user1);

            Employee user2 = new Employee();
            user2.setFirstName("Madhura");
            user2.setLastName("Chivate");
            user2.setSalary(4567);
            user2.setAge(34);
            user2.setUsername("abcd");
            user2.setPassword(passwordEncoder.encode("abcd"));
            userDao.save(user2);
        };
    }

}
