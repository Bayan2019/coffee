package kz.solva.coffee.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kz.solva.coffee.model.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>{
    
    Order findById(long id);
    // ArrayList<Order> findByCoffeeId(int coffee_id);
}
