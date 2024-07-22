package com.example.demo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/before")
    public String before() {
        return "redirect:/after";
    }

    @GetMapping("/after")
    @ResponseBody
    public String after() {
        return "hi";
    }
}
