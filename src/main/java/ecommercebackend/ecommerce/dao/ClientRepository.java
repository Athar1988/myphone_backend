package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.Product;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {


}
