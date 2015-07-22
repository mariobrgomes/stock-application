package repository;

import domain.Product;

import java.util.List;

/**
 * Created by 964456 on 14/07/2015.
 */
public interface ProductDao {

    List<Product> getProductList();
    void saveProduct(Product product);
}
