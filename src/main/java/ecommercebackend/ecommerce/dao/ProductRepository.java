package ecommercebackend.ecommerce.dao;

import ecommercebackend.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
   /* @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();
*/
    @RestResource(path = "/productsName")
    public List<Product> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/productsMarque")
    public List<Product> findByMarqueContains(@Param("mc") String mc);
    @RestResource(path = "/productsDescription")
    public List<Product> findByDescriptionContains(@Param("mc") String mc);
    @RestResource(path = "/productsCategory")
    public List<Product> findByCategoryContains(@Param("mc") String mc);

     //products/search/topOffre plus de 70%
    /*@RestResource(path = "/topOffre")
    public List<Product> findByCategoryContains(@Param("mc") String mc);
    */

    ///products/search/promo
    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();

    //products/search/produitDisponible
    @RestResource(path = "/dispoProducts")
    public List<Product> findByAvailableIsTrue();

    //dernierAjoute les 10 dernier produit
   /* @RestResource(path = "/dernierAjoute")
    public List<Product> findByAvailableIsTrue();*/
}
