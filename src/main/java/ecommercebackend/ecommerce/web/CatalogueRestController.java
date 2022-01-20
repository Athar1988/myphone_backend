package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.CategoryRepository;
import ecommercebackend.ecommerce.dao.ProductRepository;
import ecommercebackend.ecommerce.entities.Category;
import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;


@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    /*public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/



    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
    }


    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Product p=productRepository.findById(id).get();
       p.setPhotoName(file.getOriginalFilename());
       Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
       productRepository.save(p);
    }



    @PostMapping(path = "/categorie/{id}/product")
    public void ajouterProduit(@PathVariable(name="id")  Long id, @RequestBody Product p)throws Exception{
       // productRepository.findAll().add(p);
        //System.out.println(C.getProducts()+" les produits");
        //Category c= new Category();
        Category c= categoryRepository.findById(id).get();
        System.out.println(c+" la catégorie");
        System.out.println(p+" produit avant modifier");
        p.setCategory(c);
        System.out.println(p+" produit apres modifier");
        productRepository.save(p);
    }
}
