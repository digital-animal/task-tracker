package com.zahid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        String template = null;
        try {
            template = "home";

        } catch (Exception e) {
            log.info("Error: {}", e);
        }
        return template;
    }
}
