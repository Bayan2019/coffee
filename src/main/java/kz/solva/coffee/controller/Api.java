package kz.solva.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.solva.coffee.model.Coffee;
import kz.solva.coffee.model.Holiday;
import kz.solva.coffee.model.Ingridient;
import kz.solva.coffee.service.impl.CoffeeServiceImpl;
import kz.solva.coffee.service.impl.HolidayServiceImpl;
import kz.solva.coffee.service.impl.IngridientServiceImpl;
import kz.solva.coffee.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Api {

    private final HolidayServiceImpl holidayService;
    private final IngridientServiceImpl ingridientService;
    private final OrderServiceImpl orderService;
    private final CoffeeServiceImpl coffeeService;

    @GetMapping(value = "/holidays/{year}")
    public List<Holiday> Holidays(@PathVariable String year) {
        return holidayService.getHolidaysByYear(year);
    }

    @GetMapping(value = "/is-holiday/{date}")
    public Boolean isDateHoliday(@PathVariable String date) {
        return holidayService.isDateHoliday(date);
    }

    @GetMapping(value = "/stats")
    public ArrayList<Coffee> statsApi() {
        return coffeeService.getAllCoffeesSortedDesc();
    }

    @GetMapping(value = "/ingridients")
    public List<Ingridient> Ingridients() {
        return ingridientService.getAllIngridients();
    }

    @PostMapping(value="/add-coffee")
    public Coffee AddCoffee(@RequestParam String name, @RequestParam String image, @RequestParam String recipe, 
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
        
        return coffeeService.addCoffee(coffee);
    }

    @PostMapping(value = "/add-order")
    public String AddOrder(@RequestParam int coffee_id) {
        return orderService.createOrder(coffee_id);
    }
        
}
