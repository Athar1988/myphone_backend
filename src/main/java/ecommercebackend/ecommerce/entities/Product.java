package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name = "reddit_Product")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String marque;
    private double currentPrice;
    private double pourcentage;
    private boolean promotion;
    private boolean available;
    @OneToOne(mappedBy = "produit")
    private ImageModel photo;
    private int quantity;
    @ManyToOne
    @ToString.Exclude
    private  Category category;

}
