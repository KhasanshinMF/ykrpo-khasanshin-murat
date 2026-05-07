package generators;

import generators.ProductDataList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import model.ProductData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductDataGenerator {

    public static void main(String[] args) throws Exception {

        List<ProductData> products = new ArrayList<>();

        products.add(new ProductData("Blue Top"));
        products.add(new ProductData("Men Tshirt"));
        products.add(new ProductData("Sleeveless Dress"));

        ProductDataList list = new ProductDataList(products);

        JAXBContext context = JAXBContext.newInstance(ProductDataList.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(
                list,
                new File("src/test/resources/products.xml")
        );

        System.out.println("products.xml created");
    }
}