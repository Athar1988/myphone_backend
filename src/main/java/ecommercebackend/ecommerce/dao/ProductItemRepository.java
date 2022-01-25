package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
