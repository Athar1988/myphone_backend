package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.ItemsCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsCommandeRepository extends JpaRepository<ItemsCommande, Long> {
}
