package kz.solva.coffee.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Coffee;

/**
 * @author bayan
 */
@Service
public interface CoffeeService {
    ArrayList<Coffee> getAllCoffees();
    Coffee addCoffee(Coffee coffee);
    Coffee getById(int id);
    Coffee updateCoffeeOrders(Coffee coffee);
}
