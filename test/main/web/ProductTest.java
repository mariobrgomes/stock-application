package main.web;

import junit.framework.TestCase;
import domain.Product;

/**
 * Created by 964456 on 30/06/2015.
 */
public class ProductTest extends TestCase {

    private Product product;

    protected void setUp() throws Exception{
        product = new Product();
    }

    public void testGetAndSetDescription() throws Exception {
        String testDescription = "aDescription";
        assertNull(product.getDescription());
        product.setDescription(testDescription);
        assertEquals(testDescription, product.getDescription());
    }

    public void testGetAndSetPrice() throws Exception {
        double testPrice = 100.00;
        assertEquals(0,0,0);
        product.setPrice(testPrice);
        assertEquals(testPrice, product.getPrice(), 0);

    }
}