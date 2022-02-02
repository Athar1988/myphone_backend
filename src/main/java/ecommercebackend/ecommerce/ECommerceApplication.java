package ecommercebackend.ecommerce;

import ecommercebackend.ecommerce.dao.CategoryRepository;
import ecommercebackend.ecommerce.dao.ProductRepository;
import ecommercebackend.ecommerce.entities.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(
                Product.class,
                Category.class,
                Client.class,
                Commande.class,
                Payment.class,
                ProductItem.class,
                ItemsCommande.class,
                ImageModel.class);

        categoryRepository.save(new Category(null,"Telephone","bi bi-phone-fill", null));
        categoryRepository.save(new Category(null,"Tablette","bi bi-tablet-fill",null));
        categoryRepository.save(new Category(null,"Produits apple","bi bi-phone-vibrate-fill", null));
        categoryRepository.save(new Category(null,"Coque iphone","bi bi-music-player-fill",null));
        categoryRepository.save(new Category(null,"Airpods","bi bi-earbuds",null));
        categoryRepository.save(new Category(null,"Haut parleur","bi bi-megaphone-fill",null));
        categoryRepository.save(new Category(null,"Smart watch","bi bi-clock-fill",null));
        categoryRepository.save(new Category(null,"Accessoires","bi bi-keyboard-fill",null));
        categoryRepository.save(new Category(null,"Cache","bi bi-person-badge-fill",null));
        categoryRepository.save(new Category(null,"Pochette","bi bi-file-ppt-fill",null));
        categoryRepository.save(new Category(null,"Camera","bi bi-camera-fill",null));
        categoryRepository.save(new Category(null,"Divers","bi bi-gift-fill",null));
        Random rnd=new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i <3 ; i++) {
                Product p=new Product();
                p.setName(RandomString.make(18));
                p.setMarque(RandomString.make(6));
                p.setDescription(RandomString.make(25));
                p.setCurrentPrice(100+rnd.nextInt(10000));
                p.setPourcentage((100+rnd.nextInt(10000))/100);
                p.setPromotion(rnd.nextBoolean());
                p.setAvailable(rnd.nextBoolean());
                //p.setPhotoName("unknown.png");
                p.setCategory(c);
                productRepository.save(p);
            }
        });
    }
}