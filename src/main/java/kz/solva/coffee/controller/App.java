package kz.solva.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kz.solva.coffee.model.Coffee;
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

    @GetMapping(value="/ingridients")
    public String ingridientsPage(Model model) {
        model.addAttribute("coffee", coffeeService.getAllCoffees());
        return "21-main-coffee";
    }

    @GetMapping(value="/stats")
    public String statsPage(Model model) {
        model.addAttribute("coffee", coffeeService.getAllCoffees());
        return "21-main-coffee";
    }

    @PostMapping(value="/add-coffee")
    public String addCoffee(@RequestParam String name, @RequestParam String image, @RequestParam String recipe, 
                            @RequestParam int beans, @RequestParam int sugar, @RequestParam int chocolate,
                            @RequestParam int water, @RequestParam int milk)  {
        
        Coffee coffee = new Coffee();
        
        coffee.setName(name);
        coffee.setImage(image);
        coffee.setRecipe(recipe);
        coffee.setBeans(beans);
        coffee.setSugar(sugar);
        coffee.setChocolate(chocolate);
        coffee.setWater(water);
        coffee.setMilk(milk);
        
        coffeeService.addCoffee(coffee);
        return "redirect:/app/";
    }

    @PostMapping(value="/add-order")
    public String addOrder(Model model) {
        model.addAttribute("coffee", coffeeService.getAllCoffees());
        return "21-main-coffee";
    }


}
