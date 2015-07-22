package service;

import domain.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 964456 on 30/06/2015.
 */
public interface ProductManager extends Serializable {

    void increasePrice(int percentage);

    List<Product> getProducts();


}
