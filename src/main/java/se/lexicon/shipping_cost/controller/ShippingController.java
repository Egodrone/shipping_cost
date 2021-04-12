package se.lexicon.shipping_cost.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.shipping_cost.entity.Box;
import se.lexicon.shipping_cost.repository.BoxRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;


@Controller
public class ShippingController {
    BoxRepository boxRepository;


    @PostConstruct
    public void init() {

    }


    @Autowired
    public ShippingController(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/AddBoxForm")
    public String add(Model model) {
        Box box = new Box();
        model.addAttribute("box", box);

        return "AddBoxForm";
    }


    @GetMapping("/ShowBoxList")
    public String box_list() {
        return "ShowBoxList";
    }


    @PostMapping("/AddBoxForm")
    public String addBox(@ModelAttribute("box") Box box, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Create new box ");
        System.out.println(box.getCountry());
        System.out.println(box.getName());

        //if statements here
        //validation etc..
        if (bindingResult.hasErrors()) {

            return "AddBoxForm";
        } else {
            //save to the db
            //boxRepository.save();

            return "redirect:/ShowBoxList/";
        }
    }


}
