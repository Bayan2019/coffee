package kz.solva.coffee.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Coffee;
import kz.solva.coffee.model.Ingridient;
import kz.solva.coffee.repository.IngridientRepository;
import kz.solva.coffee.service.IngridientService;
import lombok.RequiredArgsConstructor;

/**
 * @author bayan
 */
@Service
@RequiredArgsConstructor
public class IngridientServiceImpl implements IngridientService{
    private final IngridientRepository ingridientRepository;

    @Override
    public ArrayList<Ingridient> getAllIngridients() {
        return (ArrayList<Ingridient>) ingridientRepository.findAll();
    }

    @Override
    public Ingridient getIngridientByName(String name) {
        return ingridientRepository.findByName(name).stream().findFirst().orElse(null);
    }

    @Override
    public Ingridient updateBeans(int beans) {
        Ingridient ingridient = getIngridientByName("beans");

        ingridient.setQuantity(ingridient.getQuantity()-beans);

        return ingridientRepository.save(ingridient);
    }

    @Override
    public Ingridient updateSugar(int sugar) {
        Ingridient ingridient = getIngridientByName("sugar");

        ingridient.setQuantity(ingridient.getQuantity()-sugar);

        return ingridientRepository.save(ingridient);
    }

    @Override
    public Ingridient updateChocolate(int chocolate) {
        Ingridient ingridient = getIngridientByName("chocolate");

        ingridient.setQuantity(ingridient.getQuantity()-chocolate);

        return ingridientRepository.save(ingridient);
    }

    @Override
    public Ingridient updateMilk(int milk) {
        Ingridient ingridient = getIngridientByName("milk");

        ingridient.setQuantity(ingridient.getQuantity()-milk);

        return ingridientRepository.save(ingridient);
    }

    @Override
    public Ingridient updateWater(int water) {
        Ingridient ingridient = getIngridientByName("water");

        ingridient.setQuantity(ingridient.getQuantity()-water);

        return ingridientRepository.save(ingridient);
    }

    @Override
    public ArrayList<Ingridient> updateIngridientsByCoffee(Coffee coffee) {
        updateBeans(coffee.getBeans());
        updateSugar(coffee.getSugar());
        updateChocolate(coffee.getChocolate());
        updateMilk(coffee.getMilk());
        updateWater(coffee.getWater());

        return getAllIngridients();
    }
}
