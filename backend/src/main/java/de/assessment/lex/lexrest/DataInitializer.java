package de.assessment.lex.lexrest;

import de.assessment.lex.lexrest.dto.data.Product;
import de.assessment.lex.lexrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.Objects;

@Component
@Profile("data")
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final ProductRepository productRepository;
    private final ConfigurableApplicationContext ctx;

    @Autowired
    public DataInitializer(ProductRepository productRepository, ConfigurableApplicationContext ctx) {
        this.productRepository = productRepository;
        this.ctx = ctx;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        clearDatabase();
        createProductAndAddToDB();
    }

    private void clearDatabase() {
        productRepository.deleteAll();
    }

    private void createProductAndAddToDB() {
        Product chocolateTart = new Product(
                "8005647003225",
                "Shokotorte",
                "Tortenboden mit Schokoladenfüllung",
                "Geminal Italis S.r.l",
                "Torten"
        );

        Product eggSalad = new Product(
                "4045800773118",
                "Eiersalat",
                "Eiersalat mit Mayonnaise",
                "Popp Feinkost GmbH",
                "Salate"
        );

        Product peanutFlips = new Product(
                "4006748001404",
                "Erdnussflips",
                "Erdnussflips mit Salz",
                "Mayka Naturbackwaren GmbH",
                "Snacks"
        );

        Product coffee = new Product(
                "4000799100512",
                "Kaffee",
                "Kaffeebohnen",
                "Nespresso GmbH",
                "Getränke"
        );

        Product strawberryJam = new Product(
                "1701509200005",
                "Erbeermarmelade",
                "Erbeermarmelade mit Zucker",
                "Marmeladenfabrik Schleswig-Holstein GmbH",
                "Marmeladen"
        );

        Product cookies = new Product(
                "3184340000542",
                "Kekse",
                "Kekse mit Doppel Schokolade",
                "Pural",
                "Kekse"
        );
        Product sweetPotatoes = new Product(
                "4005800000000",
                "Süßkartoffeln",
                "Süßkartoffeln",
                "Bioland",
                "Gemüse"
        );
        Product blackTea = new Product(
                "4005800000450",
                "Schwarzer Tee",
                "Schwarzer Tee",
                "TeeGschwendner",
                "Tee"
        );
        Product iceTea = new Product(
                "4005800000459",
                "Eistee",
                "Eistee",
                "Makava",
                "Getränke"
        );
        Product appleJuice = new Product(
                "4005800000466",
                "Apfelsaft",
                "Apfelsaft",
                "IKEA Food Services",
                "Getränke"
        );
        productRepository.save(chocolateTart);
        productRepository.save(eggSalad);
        productRepository.save(peanutFlips);
        productRepository.save(coffee);
        productRepository.save(strawberryJam);
        productRepository.save(cookies);
        productRepository.save(sweetPotatoes);
        productRepository.save(blackTea);
        productRepository.save(iceTea);
        productRepository.save(appleJuice);
    }

    private JpaRepository acquireRepository(String beanName) {
        return (JpaRepository) ctx.getBean(beanName);
    }
}
