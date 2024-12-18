package kz.solva.coffee.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Coffee;
import kz.solva.coffee.repository.CoffeeRepository;
import kz.solva.coffee.service.CoffeeService;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{
    
    private final CoffeeRepository coffeeRepository;

    @Override
    public ArrayList<Coffee> getAllCoffees() {
        return (ArrayList<Coffee>) coffeeRepository.findAll();
    }

    @Override
    public Coffee addCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public Coffee getById(int id) {
        return coffeeRepository.findById(id);
    }

    @Override
    public Coffee updateCoffeeOrders(Coffee coffee) {
        coffee.setOrders(coffee.getOrders()+1);
        return coffeeRepository.save(coffee);
    }

    @Override
    public ArrayList<Coffee> getAllCoffeesSortedDesc() {
        ArrayList<Coffee> coffees = getAllCoffees();
        coffees.sort((a, b) -> a.getOrders()>=b.getOrders() ? -1 : 1);
        return coffees;
    }
}
