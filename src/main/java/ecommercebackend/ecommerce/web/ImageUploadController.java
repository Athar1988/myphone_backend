
package ecommercebackend.ecommerce.web;


import ecommercebackend.ecommerce.dao.ImageRepository;
import ecommercebackend.ecommerce.dao.ProductRepository;
import ecommercebackend.ecommerce.entities.ImageModel;
import ecommercebackend.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "image")
public class ImageUploadController {

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/upload/{id}")
    public BodyBuilder uplaodImage(@PathVariable("id") Long idProduit, @RequestParam("imageFile") MultipartFile file) throws IOException {
        Product P=productRepository.findById(idProduit).get();
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        P.setNameImage(file.getOriginalFilename());
        P.setTypeImage(file.getContentType());
        P.setPicByte(file.getBytes());
        //ImageModel img = new ImageModel(idProduit ,file.getOriginalFilename(), file.getContentType(),
                //compressBytes(file.getBytes()), P);
        //imageRepository.save(img);
       // P.setPhoto(img);
        productRepository.save(P);
        return ResponseEntity.status(HttpStatus.OK);
    }



 /*  @GetMapping(path = { "/get/{id}" })
    public ImageModel getImage(@PathVariable("id") Long id) throws IOException {
        Product p= productRepository.findById(id).get();

        final Optional<ImageModel> retrievedImage = imageRepository.findByName(p.getNameImage());
        ImageModel img = new ImageModel(null,retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
*/

  /*  @GetMapping(path = { "products/{id}" })
    public ImageModel getImage(@PathVariable("id") Long idProduit) throws IOException {
        Product P=productRepository.findById(idProduit).get();
        ImageModel img=P.getPhoto();
        System.out.println(img.getName()+" name photo");
        final Optional<ImageModel> retrievedImage = imageRepository.findByName(img.getName());
        ImageModel img2 = new ImageModel(img.getId(),retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()), P);
        return img2;
    }*/


    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }


    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }


}
