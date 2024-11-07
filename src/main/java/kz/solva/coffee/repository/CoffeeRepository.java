package kz.solva.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.solva.coffee.model.Coffee;

/**
 * @author bayan
 */
@Repository
@Transactional
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

}
