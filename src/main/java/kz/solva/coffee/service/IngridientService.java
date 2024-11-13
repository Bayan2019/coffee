package kz.solva.coffee.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Ingridient;

/**
 * @author bayan
 */
@Service
public interface IngridientService {
    ArrayList<Ingridient> getAllIngridients();
    Ingridient getIngridientByName(String name);
}
