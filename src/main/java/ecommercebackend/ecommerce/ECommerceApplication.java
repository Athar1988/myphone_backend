package ecommercebackend.ecommerce;


import ecommercebackend.ecommerce.dao.*;
import ecommercebackend.ecommerce.entities.*;
//import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import java.util.Random;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LoginRepository loginRepository;
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
                ProductItem.class,
                ItemsCommande.class,
                ImageModel.class,
                Contact.class,
                Login.class);

        loginRepository.save(new Login(null,"best","best"));
        categoryRepository.save(new Category(null,"Telephone","fa fa-mobile-phone", null));
        categoryRepository.save(new Category(null,"Tablette","fa fa-tablet",null));
        categoryRepository.save(new Category(null,"Produits apple","fa fa-apple", null));
        categoryRepository.save(new Category(null,"Coque iphone","fa fa-square",null));
        categoryRepository.save(new Category(null,"Airpods","fa fa-headphones",null));
        categoryRepository.save(new Category(null,"Haut parleur","fa fa-step-forward",null));


        categoryRepository.save(new Category(null,"Smart watch","fa fa-watch",null));


        categoryRepository.save(new Category(null,"Accessoires","fa fa-battery-three-quarters",null));
        categoryRepository.save(new Category(null,"Cache","fa fa-mobile",null));
        categoryRepository.save(new Category(null,"Pochette","fa fa-briefcase",null));
        categoryRepository.save(new Category(null,"Camera","fa fa-camera",null));
        categoryRepository.save(new Category(null,"Divers","fa fa-gamepad",null));

       /* Random rnd=new Random();
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
        });*/
    }
}