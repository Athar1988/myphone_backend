package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository  extends JpaRepository<Panier, Long> {
}
