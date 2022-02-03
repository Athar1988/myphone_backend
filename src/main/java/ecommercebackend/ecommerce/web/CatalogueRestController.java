package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.CategoryRepository;
import ecommercebackend.ecommerce.dao.ImageRepository;
import ecommercebackend.ecommerce.dao.ProductRepository;
import ecommercebackend.ecommerce.entities.Category;
import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.ImageModel;
import ecommercebackend.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    ImageRepository imageRepository;

    /*public CatalogueRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/



  /*  @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhoto()));
    }
*/

   /* @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Product p=productRepository.findById(id).get();
       p.setPhotoName(file.getOriginalFilename());
       Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
       productRepository.save(p);
    }
*/


    @PostMapping(path = "/categorie/{id}/product")
    public void ajouterProduit(@PathVariable(name="id")  Long id, @RequestBody Product p)throws Exception{
        Category c= categoryRepository.findById(id).get();
        p.setCategory(c);
        productRepository.save(p);
    }

    //Mettre à jour un client
    @PostMapping(value ="/products/misejour/{id}")
    public Product UpdateClient(@PathVariable(name="id") Long id, @RequestBody Product P)throws Exception{
        P.setId(id);
        return productRepository.save(P);
    }


    //produit en pagonation
    //Pageable listeProduits = PageRequest.of(page, size);
   // Page<Product> allProducts = productRepository.findAll(listeProduits);



}
