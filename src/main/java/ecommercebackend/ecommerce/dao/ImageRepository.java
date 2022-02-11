package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}