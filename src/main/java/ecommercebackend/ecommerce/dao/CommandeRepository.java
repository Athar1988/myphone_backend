package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
