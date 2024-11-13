package kz.solva.coffee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bayan
 */
@Entity
@Table(name="coffee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coffee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="recipe")
    private String recipe;
    @Column(name="image")
    private String image;
    @Column(name="beans")
    private int beans;
    @Column(name = "sugar")
    private int sugar;
    @Column(name = "chocolate")
    private int chocolate;
    @Column(name = "water")
    private int water;
    @Column(name = "milk")
    private int milk;
    @Column(name = "orders")
    private long orders;
}
