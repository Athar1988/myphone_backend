package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.ClientRepository;
import ecommercebackend.ecommerce.dao.ProductItemRepository;
import ecommercebackend.ecommerce.entities.Category;
import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.Product;
import ecommercebackend.ecommerce.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin("*")
@RestController
public class ClientRestController {


    @Autowired
    private ClientRepository repClient;
    @Autowired
    private ProductItemRepository repproductItem;

    //ajouter un client
    @PostMapping(value = "/clients/AjouteClient")
    public void ajouterUtilisateur(@RequestBody Client client) {
        repClient.save(client);
    }


  //supprimer client
    @DeleteMapping(value = "/clients/supprimerClient/{id}")
    public void supprimeruserUtilisateur(@PathVariable(name="id")  Long id) {
        repClient.deleteById(id);
    }

    //Mettre à jour un client
    @PutMapping(value ="/clients/misejour{id}")
    public Client UpdateProduit(@PathVariable(name="id") Long id, @RequestBody Client C){
        C.setId(id);
        return repClient.save(C);
    }

    //ajouter Itemproduct to client
    @PostMapping(path = "client/{id}/itemproduct")
    public void ajouterProduit(@PathVariable(name="id")  Long id, @RequestBody ProductItem PI)throws Exception{
        Client c= repClient.findById(id).get();
        PI.setClient(c);
        repproductItem.save(PI);
    }

}
