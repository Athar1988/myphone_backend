package ecommercebackend.ecommerce.web;


import  ecommercebackend.ecommerce.entities.*;
import ecommercebackend.ecommerce.dao.ClientRepository;
import ecommercebackend.ecommerce.dao.OrderItemRepository;
import ecommercebackend.ecommerce.dao.OrderRepository;
import ecommercebackend.ecommerce.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderForm orderForm){
        Client client=new Client();
        client.setNom(orderForm.getClient().getNom());
        client.setEmail(orderForm.getClient().getEmail());
        client.setAddress(orderForm.getClient().getAddress());
        client.setTelephone(orderForm.getClient().getTelephone());
        client.setPrenom(orderForm.getClient().getPrenom());
        client.setVille(orderForm.getClient().getVille());
        client.setMotdepasse(orderForm.getClient().getMotdepasse());

        client=clientRepository.save(client);
        System.out.println(client.getId());

        Order order=new Order();
        //order.setClient(client);
        order.setDate(new Date());
        order=orderRepository.save(order);
        double total=0;
        for(OrderProduct p:orderForm.getProducts()){
            OrderItem orderItem=new OrderItem();
            orderItem.setOrder(order);
            Product product=productRepository.findById(p.getId()).get();
            orderItem.setProduct(product);
            orderItem.setPrice(product.getCurrentPrice());
            orderItem.setQuantity(p.getQuantity());
            orderItemRepository.save(orderItem);
            total+=p.getQuantity()*product.getCurrentPrice();
        }
        //order.setTotalAmount(total);
        return orderRepository.save(order);
    }

}