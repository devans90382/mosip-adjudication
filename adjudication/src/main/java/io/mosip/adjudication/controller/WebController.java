package io.mosip.adjudication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {

//    @Autowired
//    private CustomerDAO customerDAO;

//    @GetMapping(path = "/")
//    public String index() {
//        return "external";
//    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
//        addCustomers();
//        Iterable<Customer> customers = customerDAO.findAll();
//        model.addAttribute("customers", customers);
//        model.addAttribute("username", principal.getName());
        return "external.html";
    }
}
