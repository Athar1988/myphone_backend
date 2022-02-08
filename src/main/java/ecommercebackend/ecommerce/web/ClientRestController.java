package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.ClientRepository;
import ecommercebackend.ecommerce.dao.ProductItemRepository;
import ecommercebackend.ecommerce.entities.Client;
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
    public void supprimeruserUtilisateur(@PathVariable(name="id")  Long id)throws Exception {
        repClient.deleteById(id);
    }

    //Mettre à jour un client
    @PostMapping(value ="/clients/misejour/{id}")
    public Client UpdateClient(@PathVariable(name="id") Long id, @RequestBody Client C)throws Exception{
        C.setId(id);
        return repClient.save(C);
    }

    //ajouter Itemproduct to client
    @PostMapping(path = "client/{id}/itemproduct")
    public void ajouterProduit(@PathVariable(name="id")  Long id, @RequestBody ProductItem PI)throws Exception{
        Client c= repClient.findById(id).get();
        System.out.println(PI.getPrixtotalproduit()+" eee");
        PI.setClient(c);
        //PI.setId(PI.getId());
        repproductItem.save(PI);
    }

    //modifier la quantité commander
    @PostMapping(value = "/productItems/{id}")
    public void updateItem(@PathVariable(name="id") Long id, @RequestBody ProductItem newItem) throws Exception{
        double total=0;
        Client C= repClient.findById(id).get();
        ProductItem item=repproductItem.findById(newItem.getId()).get();
        item.setQuantiteCommander(newItem.getQuantiteCommander());
        if(item.getPourcentage()!=0){
        total=item.getPrixUn()-((newItem.getQuantiteCommander()*item.getPrixUn())*(item.getPourcentage()/100));
        }
        else{
         total=(newItem.getQuantiteCommander()*item.getPrixUn());
        }
        item.setPrixtotalproduit(total);
        item.setId(newItem.getId());
        item.setClient(C);
        repproductItem.save(item);
    }

}
