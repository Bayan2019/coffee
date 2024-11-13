package kz.solva.coffee.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

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
}
