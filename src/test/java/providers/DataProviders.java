package providers;

import generators.ProductDataList;
import jakarta.xml.bind.JAXBContext;
import model.ProductData;

import java.io.InputStream;
import java.util.stream.Stream;

public class DataProviders {
    public static Stream<ProductData> productDataFromXml() throws Exception {

        InputStream stream =
                DataProviders.class
                        .getClassLoader()
                        .getResourceAsStream("products.xml");

        if (stream == null) {
            throw new RuntimeException("products.xml not found");
        }

        JAXBContext context = JAXBContext.newInstance(ProductDataList.class);

        ProductDataList list = (ProductDataList)
                context.createUnmarshaller()
                        .unmarshal(stream);

        return list.getProducts().stream();
    }
}
