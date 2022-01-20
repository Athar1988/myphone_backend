package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reddit_Order")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    /*@OneToMany(mappedBy = "order")
    @ToString.Exclude
    private Collection<ProductItem> productsitem;
    @ManyToOne
    private Client client;
    private double totalAmount;
    @OneToOne
    private Payment payment;*/
}
