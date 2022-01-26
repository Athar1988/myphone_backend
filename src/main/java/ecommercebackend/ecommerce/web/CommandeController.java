package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.dao.*;
import ecommercebackend.ecommerce.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;


    //ajouter un commande
    @PostMapping(value = "/commandes/AjouteCommande")
    public void ajouterCommande(@RequestBody Commande commande)
    {
        commandeRepository.save(commande);
    }




}
