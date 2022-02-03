package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.*;
import ecommercebackend.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private ItemsCommandeRepository repitemsCommande;

    //ajouter un commande
    @PostMapping("/ajoutercommandes")
    public void ajouterCommande(@RequestBody OrderForm orderForm)
    {
        Client client= repClient.getById(orderForm.getClient().getId());
        Commande commande=new Commande();
        commande.setClient(client);
        commande.setDate(new Date());
        commande.setStatut("En cours");
        double total=0;
        for(ItemsCommande p:orderForm.getProducts()) {
            ProductItem item=repproductItem.findById(p.getId()).get();
            total+= item.getPrixtotalproduit();
        }
        commande.setTotalAmount(total);
        commande.setItemsCommande(orderForm.getProducts());
        commandeRepository.save(commande);

        for(ItemsCommande p:orderForm.getProducts()) {
            ProductItem item=repproductItem.findById(p.getId()).get();
            ItemsCommande itemsCommande= new ItemsCommande(p.getId(), item.getName(),item.getQuantiteCommander(), item.getPourcentage(), item.getPrixUn(), item.getPrixtotalproduit(),item.getNameImage(),item.getTypeImage(),item.getPicByte(), item.getClient(), null);
            itemsCommande.setCommande(commande);
            repitemsCommande.save(itemsCommande);
        }

    }


    //Mettre à jour commande
    @PostMapping(value ="/traitercommandes/{id}")
    public Commande UpdateCommande(@PathVariable(name="id") Long id, @RequestBody Commande C)throws Exception{
        C.setId(id);
        C.setStatut("Terminer");
        return commandeRepository.save(C);
    }

  /*  @GetMapping(value = "/clients/id/commande")
    public Collection<Commande>  recupereTousCommande(@RequestBody Long id){
        Client C= repClient.findById(id).get();
        Collection<Commande> listeCommande= C.getCommande();
        return  listeCommande;
    }*/

}
