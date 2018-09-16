package com.myFinance.controller;

import com.myFinance.MainFinanceApplication;
import com.myFinance.entity.TransactionItem;
import com.myFinance.service.TransactionItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(MainFinanceApplication.class);

    @Autowired
    private TransactionItemService transactionItemService;

    private TransactionItem transactionItem;

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

    // Transaction PAGE
    @RequestMapping("/transaction")
    public String transaction(Model model) {
        log.info("Transaction PAGE Loading");

        TransactionItem transactionItem = new TransactionItem();

        model.addAttribute("item",transactionItem);
        model.addAttribute("directions", TransactionItem.Direction.values());
        model.addAttribute("currencies", TransactionItem.Currency.values());

        return "/transaction";
    }

    // Transaction PAGE
    @RequestMapping(value = "/transaction/make", method = RequestMethod.POST)
    public String transaction(@ModelAttribute TransactionItem item, final RedirectAttributes redirectAttrs) {
        log.info("Transaction PAGE");
        log.info(">> [transaction] - transaction Registration - POST | getQuantity: {}", item.getQuantity());

        item.setQuantity(item.getQuantity().replace(",",""));
        log.info("item.getQuantity(): " + item.getQuantity());

        if(Integer.parseInt(item.getQuantity()) > 0){
            log.info("Integer.parseInt(item.getQuantity()): " + Integer.parseInt(item.getQuantity()));

            transactionItemService.makeTransaction(item);
            return "redirect:/finsum";
        }
        else{
            String errorMsg = "The Quantity cannot be ZERO!";
            log.warn(errorMsg);
            redirectAttrs.addFlashAttribute("transactError", true);
            redirectAttrs.addFlashAttribute("transMsg", errorMsg);
            return "redirect:/transaction";
        }
    }

    // Financial Summarise
    @RequestMapping("/finsum")
    public String finsum(Model model) {
        log.info("Financial Summarise PAGE");

        List<TransactionItem> items = transactionItemService.getAllTransaction();

        for (TransactionItem item : items) {
            log.info(" Item: "+item.getTransactionNumber());
            log.info(" Item: "+item.getQuantity());
        }

        model.addAttribute("items",items);

        return "/finsum";
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
