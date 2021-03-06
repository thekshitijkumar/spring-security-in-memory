package com.spring.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/student")
    public String greetUser(@RequestParam String name)
    {
        return "Hello Student "+name;
    }

    @GetMapping("/faculty")
    public String getFaculty(@RequestParam String name)
    {
        return "Hello faculty "+name;
    }
    @GetMapping("/")
    public String getUser(@RequestParam String name)
    {
        return "Hello user "+name;
    }
}
