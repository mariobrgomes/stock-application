package repository;

import domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 964456 on 14/07/2015.
 */
public class JdbcProductDao extends SimpleJdbcDaoSupport implements ProductDao {

    protected final Log logger = LogFactory.getLog(getClass());

    public List<Product> getProductList() {
        logger.info("Getting products");
        List<Product> products = getSimpleJdbcTemplate().query("SELECT id, description, price FROM products", new ProductMapper());
        return products;
    }

    public void saveProduct(Product product) {
        logger.info("Saving product: " + product.getDescription());

        int count = getSimpleJdbcTemplate().update("UPDATE products SET description = :description,price, = :price where id = :id");
        new MapSqlParameterSource().addValue("description", product.getDescription())
                .addValue("price", product.getPrice())
                .addValue("id", product.getId());
        logger.info("Rows affected: " +count);
    }
    public static class ProductMapper implements ParameterizedRowMapper<Product> {

        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            return product;
        }
    }
}
