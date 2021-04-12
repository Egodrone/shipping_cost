package se.lexicon.shipping_cost.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.shipping_cost.entity.Box;

import javax.annotation.PostConstruct;
import javax.validation.Valid;


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
    public String box_list() {
        return "ShowBoxList";
    }


    @PostMapping("/AddBoxForm")
    public String addBox(@ModelAttribute("box") Box box, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Create new box ");

        //if statements here
        //validation etc..
        if (bindingResult.hasErrors()) {

            return "AddBoxForm";
        } else {
            //save to the db

            return "redirect:/ShowBoxList/";
        }
    }


}
