package kz.solva.coffee.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Coffee;
import kz.solva.coffee.model.Ingridient;

/**
 * @author bayan
 */
@Service
public interface IngridientService {
    ArrayList<Ingridient> getAllIngridients();
    Ingridient getIngridientByName(String name);
    Ingridient updateBeans(int beans);
    Ingridient updateSugar(int sugar);
    Ingridient updateChocolate(int chocolate);
    Ingridient updateMilk(int milk);
    Ingridient updateWater(int water);
    ArrayList<Ingridient> updateIngridientsByCoffee(Coffee coffee);
}
