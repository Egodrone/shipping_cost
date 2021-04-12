package se.lexicon.shipping_cost.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;


@Controller
public class ShippingController {


    @PostConstruct
    public void init() {

    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/AddBoxForm")
    public String add() {
        return "AddBoxForm";
    }


    @GetMapping("/ShowBoxList")
    public String index_test() {
        return "ShowBoxList";
    }



}
