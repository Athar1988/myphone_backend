package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.*;
import ecommercebackend.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ClientRepository repClient;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductItemRepository repproductItem;


    //ajouter un commande
    @PostMapping("/commandes")
    public void ajouterCommande(@RequestBody OrderForm orderForm)
    {
        /*Client client=new Client();
        client.setNom(orderForm.getClient().getNom());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAddress(orderForm.getClient().getAddress());
        client.setTelephone(orderForm.getClient().getTelephone());
        client.setPrenom(orderForm.getClient().getPrenom());
        client.setMotdepasse(orderForm.getClient().getMotdepasse());
        client.setVille(orderForm.getClient().getVille());
        client=repClient.save(client);
        System.out.println(client.getId());
        */

        Client client= repClient.getById(orderForm.getClient().getId());
        Commande commande=new Commande();
        commande.setClient(client);
        commande.setDate(new Date());
        commande.setStatut("Envoyer");
        double total=0;
        for(ProductItem p:orderForm.getProducts()) {
            ProductItem item=repproductItem.findById(p.getId()).get();
            System.out.println(item.getPrixtotalproduit()+" rrrr");
            total+= item.getPrixtotalproduit();
            item.setCommande(commande);
        }
        System.out.println(total+" le total");
        commande.setTotalAmount(total);
        commande.setProductsitem(orderForm.getProducts());
        commandeRepository.save(commande);

        /*for(ProductItem p:orderForm.getProducts()){
            ProductItem item=repproductItem.findById(p.getId()).get();
            item.setCommande(commande);


            orderItem.setProduct(product);
            orderItem.setPrice(product.getCurrentPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
        }
         commandeRepository.save(commande);*/
    }

}

