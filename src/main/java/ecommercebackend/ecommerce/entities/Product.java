package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

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
    @Column(length=10485760)
    private String description;
    private String marque;
    private double currentPrice;
    private double pourcentage;
    private boolean promotion;
    private boolean available;
    private String nameImage;
    private String typeImage;
    private byte[] picByte;
    private int quantity;
    @ManyToOne
    @ToString.Exclude
    @Lazy
    private  Category category;

}
