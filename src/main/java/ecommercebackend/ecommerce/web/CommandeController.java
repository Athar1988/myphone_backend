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
        Client client= repClient.getById(orderForm.getClient().getId());
        Commande commande=new Commande();
        commande.setClient(client);
        commande.setDate(new Date());
        commande.setStatut("En cours");
        double total=0;
        for(ProductItem p:orderForm.getProducts()) {
            ProductItem item=repproductItem.findById(p.getId()).get();
            total+= item.getPrixtotalproduit();
            item.setCommande(commande);
        }
        commande.setTotalAmount(total);
        commande.setProductsitem(orderForm.getProducts());
        commandeRepository.save(commande);

    }

}

