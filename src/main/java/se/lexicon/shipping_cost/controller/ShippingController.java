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
    public String box_list(Model model) {
        model.addAttribute("boxList", boxRepository.findAll());

        return "ShowBoxList";
    }


    @PostMapping("/AddBoxForm")
    public String addBox(@ModelAttribute("box") @Valid Box box, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            return "AddBoxForm";
        } else {

            // Calculate shipping cost:
            if (box.getWeightType().equalsIgnoreCase("KG")) {
                double calculatedCost = box.getWeight() * 1000;
                System.out.println("Calculated cost: " + calculatedCost);
                box.setCost(calculatedCost);
            }

            if (box.getWeightType().equalsIgnoreCase("G")) {
                double calculatedCostGram = box.getWeight() * 2;
                System.out.println("Calculated cost: " + calculatedCostGram);
                box.setCost(calculatedCostGram);
            }

            boxRepository.save(box);
        }

        return "redirect:/ShowBoxList/";
    }


}
