package kz.solva.coffee.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.solva.coffee.model.Ingridient;

/**
 * @author bayan
 */
@Repository
@Transactional
public interface IngridientRepository extends JpaRepository<Ingridient, Integer>{
    ArrayList<Ingridient> findByName(String name);
}
