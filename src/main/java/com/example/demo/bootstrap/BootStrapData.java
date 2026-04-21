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

        if (productRepository.count() == 0)
        {
            Product mightyMouse = new Product("Mighty Mouse", 19.95, 13);
            Product freshman = new Product("Freshman", 29.99, 15);
            Product bigBoy = new Product("Big Boy", 45.99, 15);
            Product thunderClap = new Product("Thunder Clap", 60.00, 10);
            Product terminator1000 = new Product("Terminator 1000", 89.99, 7);

            productRepository.save(mightyMouse);
            productRepository.save(freshman);
            productRepository.save(bigBoy);
            productRepository.save(thunderClap);
            productRepository.save(terminator1000);
        }

        if (partRepository.count() == 0)
        {
            InhousePart noseCone = new InhousePart();
            noseCone.setName("nose cone");
            noseCone.setPrice(10.99);
            noseCone.setInv(20);
            noseCone.setMinInv(1);
            noseCone.setMaxInv(30);

            InhousePart parachute = new InhousePart();
            parachute.setName("parachute");
            parachute.setPrice(10.99);
            parachute.setInv(30);
            parachute.setMinInv(1);
            parachute.setMaxInv(40);

            InhousePart fins = new InhousePart();
            fins.setName("fins");
            fins.setPrice(5.99);
            fins.setInv(40);
            fins.setMinInv(1);
            fins.setMaxInv(50);

            InhousePart engine = new InhousePart();
            engine.setName("engine");
            engine.setPrice(15.99);
            engine.setInv(60);
            engine.setMinInv(1);
            engine.setMaxInv(70);

            InhousePart body = new InhousePart();
            body.setName("body");
            body.setPrice(20.99);
            body.setInv(30);
            body.setMinInv(1);
            body.setMaxInv(40);

            partRepository.save(noseCone);
            partRepository.save(parachute);
            partRepository.save(fins);
            partRepository.save(engine);
            partRepository.save(body);
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
