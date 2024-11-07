package kz.solva.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kz.solva.coffee.service.impl.CoffeeServiceImpl;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@Controller
@RequiredArgsConstructor
public class Home {

    private final CoffeeServiceImpl coffeeService;

    @GetMapping(value="/")
    public String mainPage(Model model) {
        model.addAttribute("coffee", coffeeService.getAllCoffees());
        return "21-main-coffee";
    }

}
