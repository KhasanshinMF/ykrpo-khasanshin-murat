package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductData {

    @XmlElement
    private String name;

    public ProductData() {}

    public ProductData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}