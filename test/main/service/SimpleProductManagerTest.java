package main.service;

import domain.Product;
import junit.framework.TestCase;
import service.SimpleProductManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 964456 on 30/06/2015.
 */
public class SimpleProductManagerTest extends TestCase {

    private static final int PRODUCT_COUNT = 2;

    private static final Double CHAIR_PRICE = new Double(20.50);
    private static final String CHAIR_DESCRIPTION = "Chair";

    private static final Double TABLE_PRICE = new Double(150.10);
    private static final String TABLE_DESCRIPTION = "Table";

    private static final int POSITIVE_PRICE_INCREASE = 10;

    private SimpleProductManager productManager;
    private List<Product> products;

    public void setUp() throws Exception {
        productManager = new SimpleProductManager();
        products =  new ArrayList<Product>();

        Product product = new Product();
        product.setDescription("Chair");
        product.setPrice(CHAIR_PRICE);
        products.add(product);

        product = new Product();
        product.setDescription("Table");
        product.setPrice(TABLE_PRICE);
        products.add(product);

        productManager.setProducts(products);

    }

    public void testGetProductsWithNoProducts(){
        productManager = new SimpleProductManager();
        assertNull(productManager.getProducts());
    }

    public void testIncreasePriceWithNullListOfProducts() throws Exception {
        try {
            productManager = new SimpleProductManager();
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        } catch (NullPointerException ex) {
            fail("Product list is empty");
        }

    }

    public void testIncreasePriceWithEmptyListOfProducts() throws Exception {
        try {
            productManager = new SimpleProductManager();
            productManager.setProducts(new ArrayList<Product>());
            productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        } catch (Exception ex) {
            fail("Product list is empty");
        }

    }

    public void testIncreasePriceWithPositivePercentage() throws Exception {
        productManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedChairPriceWithIncrease = 22.55;
        double expectedTablePriceWithIncrease = 165.11;

        List<Product> products = productManager.getProducts();
        Product product = products.get(0);
        assertEquals(expectedChairPriceWithIncrease, product.getPrice());

        product = products.get(1);
        assertEquals(expectedTablePriceWithIncrease, product.getPrice());
    }

    public void testGetProducts() throws Exception {

        List<Product> products = productManager.getProducts();
        assertNotNull(products);
        assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

        Product product = products.get(0);
        assertEquals(CHAIR_DESCRIPTION, product.getDescription());
        assertEquals(CHAIR_PRICE, product.getPrice());

        product = products.get(1);
        assertEquals(TABLE_DESCRIPTION, product.getDescription());
        assertEquals(TABLE_PRICE, product.getPrice());


    }

    public void testSetProducts() throws Exception {

    }
}