package kz.solva.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping(value="/")
    public String mainPage(Model model) {
        return "21-main-coffee";
    }

}
