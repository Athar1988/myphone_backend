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
@ToString
@Table(name = "reddit_Product")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String marque;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @Transient
    private int quantity=1;
    @ManyToOne
    private  Category category;
}
