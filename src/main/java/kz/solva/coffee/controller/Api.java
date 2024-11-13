package kz.solva.coffee.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kz.solva.coffee.model.Holiday;
import kz.solva.coffee.model.Ingridient;
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

    @GetMapping(value = "/holidays/{year}")
    public List<Holiday> Holidays(@PathVariable String year) {
        return holidayService.getHolidaysByYear(year);
    }

    @GetMapping(value = "/ingridients")
    public List<Ingridient> Ingridients() {
        return ingridientService.getAllIngridients();
    }

    @GetMapping(value = "/ingridients/{name}")
    public Ingridient IngridientByName(@PathVariable String name) {
        return ingridientService.getIngridientByName(name);
    }

    @PostMapping(value = "/add-order")
    public String AddOrder(@RequestParam int coffee_id) {
        return orderService.createOrder(coffee_id);
    }

    @GetMapping(value = "/date/time")
    public String DateTime() {
        Date currenDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime time = currenDate.toInstant().atZone(ZoneId.of("Asia/Almaty"));
        return formatter.format(time);
    }

    @GetMapping(value = "/date/time/is-after-17")
    public Boolean isLate() {
        Date currenDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime time = currenDate.toInstant().atZone(ZoneId.of("Asia/Almaty"));
        return formatter.format(time).compareTo("17:00:00")>0;
    }

    @GetMapping(value = "/date/time/is-before-08")
    public Boolean isBefore() {
        Date currenDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime time = currenDate.toInstant().atZone(ZoneId.of("Asia/Almaty"));
        return formatter.format(time).compareTo("08:00:00")<0;
    }

    @GetMapping(value = "/date/time/is-after-17/{time}")
    public Boolean isDateTimeLate(@PathVariable String time) {
        return time.compareTo("17:00:00")>0;
    }

    @GetMapping(value = "/date/time/is-before-08/{time}")
    public Boolean isDateTimeBefore(@PathVariable String time) {
        return time.compareTo("08:00:00")<0;
    }

    @GetMapping(value = "/is-holiday/")
    public Boolean isHoliday() {
        return holidayService.isTodayHoliday();
    }

    @GetMapping(value = "/is-holiday/{date}")
    public Boolean isDateHoliday(@PathVariable String date) {
        return holidayService.isDateHoliday(date);
    }
        
}
