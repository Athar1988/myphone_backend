package ecommercebackend.ecommerce.web;


import ecommercebackend.ecommerce.dao.ProductItemRepository;
import ecommercebackend.ecommerce.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ProductItemRestController {

    @Autowired
    private ProductItemRepository productitemRepository;






    @DeleteMapping(value = "/productItems/{id}")
    public void supprimerItem(@PathVariable(name="id")  Long idItem) {
        productitemRepository.deleteById(idItem);
    }




}
