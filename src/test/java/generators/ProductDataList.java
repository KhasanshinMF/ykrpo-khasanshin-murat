package generators;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import model.ProductData;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDataList {

    @XmlElement(name = "product")
    private List<ProductData> products;

    public ProductDataList() {
    }

    public ProductDataList(List<ProductData> products) {
        this.products = products;
    }

    public List<ProductData> getProducts() {
        return products;
    }
}