package kz.solva.coffee.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Coffee;
import kz.solva.coffee.model.Order;
import kz.solva.coffee.repository.OrderRepository;
import kz.solva.coffee.service.OrderService;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final HolidayServiceImpl holidayService;
    private final CoffeeServiceImpl coffeeService;
    private final IngridientServiceImpl ingridientService;

    @Override
    public String createOrder(int coffee_id) {
        if (holidayService.isTodayHoliday()) {
            return "today is holiday";
        }
        if (isBefore()) {
            return "it is not yet 08:00";
        }
        if (isLate()) {
            return "it is passed 17:00";
        }

        Coffee coffee = coffeeService.getById(coffee_id);
        if (ingridientService.getIngridientByName("beans").getQuantity() < coffee.getBeans()) {
            return "not enough coffee beans";
        }
        if (ingridientService.getIngridientByName("sugar").getQuantity() < coffee.getSugar()) {
            return "not enough sugar";
        }
        if (ingridientService.getIngridientByName("chocolate").getQuantity() < coffee.getChocolate()) {
            return "not enough chocolate";
        }
        if (ingridientService.getIngridientByName("milk").getQuantity() < coffee.getMilk()) {
            return "not enough milk";
        }
        if (ingridientService.getIngridientByName("water").getQuantity() < coffee.getWater()) {
            return "not enough water";
        }
        
        coffee = coffeeService.updateCoffeeOrders(coffee);

        Date currenDate = new Date();
        
        Order order = new Order();

        order.setCoffee(coffee);
        order.setDate(currenDate);

        orderRepository.save(order);

        return "created";
    }

    private Boolean isLate() {
        Date currenDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime time = currenDate.toInstant().atZone(ZoneId.of("Asia/Almaty"));
        return formatter.format(time).compareTo("17:00:00")>0;
    }

    private Boolean isBefore() {
        Date currenDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        ZonedDateTime time = currenDate.toInstant().atZone(ZoneId.of("Asia/Almaty"));
        return formatter.format(time).compareTo("08:00:00")<0;
    }
}
