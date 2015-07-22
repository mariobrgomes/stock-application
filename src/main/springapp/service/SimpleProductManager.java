package service;

import domain.Product;
import service.ProductManager;

import java.util.List;

/**
 * Created by 964456 on 30/06/2015.
 */
public class SimpleProductManager implements ProductManager {

    private List<Product> products;

    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
