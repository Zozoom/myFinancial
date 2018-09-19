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
import java.util.Arrays;
import java.util.List;

@Controller
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(MainFinanceApplication.class);

    /**
     * tis ==> Transaction Item Service
     * */
    @Autowired
    private TransactionItemService tis;

    /**
     * Default Home Page
     * */
    @RequestMapping("/")
    public String home(Model model) {
        log.info(">> [Controller|home] - Getting to the Home page.");

        int income = tis.getAllIncome();
        int expense = tis.getAllExpense();

        model.addAttribute("incomes", income);
        model.addAttribute("expense", expense);

        int diff = income - expense;
        model.addAttribute("differ", diff);

        log.info(">> [Controller|home] - Attributes added, loading home...");
        return "/home";
    }

    /**
     * Transaction Page
     * */
    @RequestMapping("/transaction")
    public String transaction(Model model) {
        log.info(">> [Controller|transaction] - Getting to the Transaction page.");

        TransactionItem transactionItem = new TransactionItem();

        model.addAttribute("item",       transactionItem);
        model.addAttribute("directions", TransactionItem.Direction.values());
        model.addAttribute("cards",      TransactionItem.Cards.values());
        model.addAttribute("category",   TransactionItem.Category.values());

        log.info(">> [Controller|transaction] - Attributes added, loading transactions...");
        return "/transaction";
    }

    /**
     * Transaction Creating Endpoint
     * Send transaction item to persist.
     * */
    @RequestMapping(value = "/transaction/make", method = RequestMethod.POST)
    public String transactionPersist(@ModelAttribute TransactionItem item, final RedirectAttributes redirectAttrs) {
        log.info(">> [Controller|transactionPersist] - Called the transactionPersist endpoint.");

        // Define error message.
        String errorMsg = "The Quantity number is invalid!";
        String succesMsg = "Transaction successfully saved.";

        if(tis.makeTransaction(item)){
            log.info(">> [Controller|transactionPersist] - Transaction successfully saved.");
            redirectAttrs.addFlashAttribute("transactSaved", true);
            redirectAttrs.addFlashAttribute("transMsg", succesMsg);
            return "redirect:/transaction";
        }
        else{
            log.warn(">> [Controller|transactionPersist] - There was an error: " + errorMsg);
            redirectAttrs.addFlashAttribute("transactError", true);
            redirectAttrs.addFlashAttribute("transMsg", errorMsg);
            return "redirect:/transaction";
        }
    }

    /**
     * Summary Page
     * */
    @RequestMapping("/summary")
    public String summary(Model model) {
        log.info(">> [Controller|summary] - Getting to the Summary page.");

        List<TransactionItem> items = tis.getAllTransaction();

        model.addAttribute("category", TransactionItem.Category.values());
        model.addAttribute("items",items);

        log.info(">> [Controller|summary] - Attributes added, loading transaction...");
        return "/summary";
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
