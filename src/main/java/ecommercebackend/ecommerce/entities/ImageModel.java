package ecommercebackend.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image_table")
public class ImageModel implements Serializable{

    @Id
    @Column(name = "id")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private byte[] picByte;
    @OneToOne
    private Product produit;





}


