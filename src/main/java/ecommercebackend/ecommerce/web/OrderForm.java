package ecommercebackend.ecommerce.web;

import ecommercebackend.ecommerce.entities.Client;
import ecommercebackend.ecommerce.entities.ItemsCommande;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderForm {
    private Client client=new Client();
    private List<ItemsCommande> products=new ArrayList<>();
}

@Data
class OrderProduct{
    private Long id;
    private int quantity;

}
