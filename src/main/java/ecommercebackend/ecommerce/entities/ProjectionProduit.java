package ecommercebackend.ecommerce.entities;

import org.springframework.data.rest.core.config.Projection;


@Projection(name="P1", types=Product.class)
public interface ProjectionProduit {
    public Long getid();
    public String getname();
    public String getdescription();
    public String getmarque();
    public double getcurrentPrice();
    public double getpourcentage();
    public boolean getpromotion();
    public boolean getavailable();
    public String getnameImage();
    public String gettypeImage();

}
