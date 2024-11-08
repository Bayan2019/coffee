package kz.solva.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kz.solva.coffee.service.impl.CoffeeServiceImpl;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class App {

    private final CoffeeServiceImpl coffeeService;

    @GetMapping(value="/")
    public String mainPage(Model model) {
        model.addAttribute("coffee", coffeeService.getAllCoffees());
        return "21-main-coffee";
    }

}
