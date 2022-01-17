package ecommercebackend.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reddit_Client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String telephone;
    private String nom;
    private String prenom;
    private String ville;
    private String address;
    private String motdepasse;
    @OneToOne
    private Panier panier;
    @OneToOne
    private Order order;

}
