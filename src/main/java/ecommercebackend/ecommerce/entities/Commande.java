package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reddit_Commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String statut;
    @OneToMany(mappedBy = "commande")
    @ToString.Exclude
    private Collection<ItemsCommande> itemsCommande;
    @ManyToOne
    private Client client;
    private double totalAmount;
    @OneToOne
    private Payment payment;
}
