package main.domain;

import domain.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import repository.ProductDao;

import java.util.List;

/**
 * Created by 964456 on 14/07/2015.
 */
public class JdbcProductDaoTests extends AbstractTransactionalDataSourceSpringContextTests {

    @Setter @Getter private ProductDao productDao;

    @Override
    protected String[] getConfigLocations(){
        return new String[] {"classpath:test-context.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.deleteFromTables(new String[] {"products"});
        super.executeSqlScript("file:db/load_data.sql", true);
    }

    public void testGetProducts(){
        List<Product> products = productDao.getProductList();

        assertEquals("wrong number of products?", 3, products.size());
    }

    public void testSaveProduct() {
        List<Product> products = productDao.getProductList();

        for (Product product : products) {
            product.setPrice(200.12);
            productDao.saveProduct(product);
        }

        List<Product> updatedProducts = productDao.getProductList();

        for (Product product : updatedProducts) {
            assertEquals("wrong piece of product?", 200.12, product.getPrice());
        }

    }
}
