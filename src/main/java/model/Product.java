package model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String description;
    private String productName;
    private BigDecimal price;
    private String imagePath;

    public Product(Long id, String productName, String description, BigDecimal price, String imagePath) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
