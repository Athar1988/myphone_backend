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
@Table(name = "reddit_ProductItem")
public class ProductItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantiteCommander;
    private double pourcentage;
    private double prixUn;
    private double prixtotalproduit;
    private String nameImage;
    private String typeImage;
    private byte[] picByte;
    @ManyToOne
    @ToString.Exclude
    private  Client client;
    /*@ManyToOne
    @ToString.Exclude
    private  Commande commande;*/
}
