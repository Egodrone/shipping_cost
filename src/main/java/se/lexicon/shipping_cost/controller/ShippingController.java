package se.lexicon.shipping_cost.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;


@Controller
public class ShippingController {


    @PostConstruct
    public void init() {

    }


    @GetMapping("/AddBoxForm")
    public String index() {
        return "AddBoxForm";
    }


}
