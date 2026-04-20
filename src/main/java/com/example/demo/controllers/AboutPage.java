package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPage {

    @GetMapping("/about")
    public String getAboutPage() {
        // Returns the name of the template file without the .html extension
        return "about";
    }
}
