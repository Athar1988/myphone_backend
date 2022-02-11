package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.*;
import ecommercebackend.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    ImageRepository imageRepository;

    @PostMapping(path = "/categorie/{id}/product")
    public void ajouterProduit(@PathVariable(name="id")  Long id, @RequestBody Product p)throws Exception{
        Category c= categoryRepository.findById(id).get();
        p.setCategory(c);
        productRepository.save(p);
    }

    //Mettre à jour un client
    @PostMapping(value ="/products/misejour/{idProd}/{idCat}")
    public Product UpdateClient(@PathVariable(name="idProd") Long idProd,@PathVariable(name="idCat") Long idCat, @RequestBody Product P)throws Exception{
        Category c= categoryRepository.findById(idCat).get();
        P.setCategory(c);
        P.setId(idProd);
        return productRepository.save(P);
    }

}

