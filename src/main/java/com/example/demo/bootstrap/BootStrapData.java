package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(partRepository.count() == 0) {

            //Adding sample part inventory for a outsourcedPart
            OutsourcedPart screws = new OutsourcedPart();
            OutsourcedPart glass = new OutsourcedPart();
            OutsourcedPart doorknob = new OutsourcedPart();
            OutsourcedPart shelvingbracket = new OutsourcedPart();

            //setting the values of the new objects.
            screws.setCompanyName("Denver Supply Co");
            screws.setName("screws");
            screws.setInv(12560);
            screws.setPrice(.01);
            screws.setId(10);
            screws.setMinInv(500);
            screws.setMaxInv(3000);

            glass.setCompanyName("Denver Supply Co");
            glass.setName("glass");
            glass.setInv(100);
            glass.setPrice(49.99);
            glass.setId(11);
            glass.setMinInv(10);
            glass.setMaxInv(1000);

            doorknob.setCompanyName("Denver Supply Co");
            doorknob.setName("door knob");
            doorknob.setInv(100);
            doorknob.setPrice(9.99);
            doorknob.setId(12);
            doorknob.setMinInv(10);
            doorknob.setMaxInv(1000);

            shelvingbracket.setCompanyName("Denver Supply Co");
            shelvingbracket.setName("shelving bracket");
            shelvingbracket.setInv(1000);
            shelvingbracket.setPrice(.99);
            shelvingbracket.setId(13);
            shelvingbracket.setMinInv(500);
            shelvingbracket.setMaxInv(3000);

            //saving parts to repository
            outsourcedPartRepository.save(screws);
            outsourcedPartRepository.save(glass);
            outsourcedPartRepository.save(doorknob);
            outsourcedPartRepository.save(shelvingbracket);

            //Adding sample inventory for inhouse part
            InhousePart wood = new InhousePart();

            //setting the values for the new objects for inhouse parts
            wood.setName("wood");
            wood.setInv(1000);
            wood.setPrice(4.99);
            wood.setId(1);
            wood.setMinInv(100);
            wood.setMaxInv(5000);

            //save to repository
            partRepository.save(wood);
        }

        if (productRepository.count() == 0) {


            //Creating an object from the Product class
            Product bench = new Product(100, "Bench", 59.99, 15);
            Product table = new Product(101, "Table", 69.99, 15);
            Product bookshelf = new Product(102, "Book Shelf", 49.00, 10);
            Product chair = new Product(103, "chair", 29.00, 20);
            Product door = new Product(104, "door", 149.99, 8);

            //saving products to repository
            productRepository.save(bench);
            productRepository.save(table);
            productRepository.save(bookshelf);
            productRepository.save(chair);
            productRepository.save(door);
        }




       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
