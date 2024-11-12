package kz.solva.coffee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.solva.coffee.model.Holiday;
import kz.solva.coffee.service.impl.HolidayServiceImpl;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Api {

    private final HolidayServiceImpl holidayService;

    @GetMapping(value = "/holidays/{year}")
    public List<Holiday> Holidays(@PathVariable int year) throws IOException, InterruptedException {
        return holidayService.getHolidaysByYear(year);
    }
        
}
