package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reddit_Client")
public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String telephone;
    private String nom;
    private String prenom;
    private String ville;
    @Column(length=10485760)
    private String address;
    private String motdepasse;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private Collection<ProductItem> productItems;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private Collection<Commande> commande;
}


