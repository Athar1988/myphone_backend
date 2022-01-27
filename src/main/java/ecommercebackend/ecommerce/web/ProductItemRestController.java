package ecommercebackend.ecommerce.web;


import ecommercebackend.ecommerce.dao.ClientRepository;
import ecommercebackend.ecommerce.dao.ProductItemRepository;
import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@CrossOrigin("*")
@RestController
public class ProductItemRestController {

    @Autowired
    private ProductItemRepository productitemRepository;
    @Autowired
    private ClientRepository repClient;

    //supprimer item
    @DeleteMapping(value = "/productItems/{id}")
    public void supprimerItem(@PathVariable(name="id")  Long idItem) {
        productitemRepository.deleteById(idItem);
    }


    //supprimer item
    @DeleteMapping(value = "supprimerTousItems/{id}")
    public void supprimerTousItem(@PathVariable(name="id")  Long id) {
        Client c = repClient.findById(id).get();
        Collection<ProductItem> PI = c.getProductItems();
        Object[] items = PI.toArray();
        for (int i = 0; i < items.length; i++) {
            ProductItem y = (ProductItem) items[i];
            Long iditem = y.getId();
            productitemRepository.deleteById(iditem);

        }
    }


}
