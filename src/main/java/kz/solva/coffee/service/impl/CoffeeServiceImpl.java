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

}
