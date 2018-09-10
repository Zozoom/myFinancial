package com.myFinance.controller;

import com.myFinance.MainFinanceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(MainFinanceApplication.class);

    // Default Home Page
    @RequestMapping("/")
    public String home1() {
        log.info("HOME PAGE");
        return "/home";
    }

    // Default Home Page 2
    @RequestMapping("/home")
    public String home() {
        log.info("HOME PAGE");
        return "/home";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        log.info("Login PAGE");
        return "/login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        log.info("Login error PAGE");
        model.addAttribute("loginError", true);
        return "/login";
    }

    @RequestMapping("/admin")
    public String admin() {
        log.info("ADMIN PAGE");
        return "/admin";
    }

    @RequestMapping("/user")
    public String user() {
        log.info("USER PAGE");
        return "/user";
    }

    @RequestMapping("/about")
    public String about() {
        log.info("About PAGE");
        return "/about";
    }

    @RequestMapping("/signup")
    public String signup() {
        log.info("Sign Up PAGE");
        return "/signup";
    }

    @RequestMapping("/403")
    public String error403() {
        log.info("403 PAGE");
        return "/error/403";
    }

}
