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
@Table(name="ingridients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingridient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "measure")
    private String measure;
    @Column(name = "image")
    private String image;
    @Column(name = "quantity")
    private int quantity;
}
