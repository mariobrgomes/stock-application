package domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 964456 on 30/06/2015.
 */


@Data
public class Product implements Serializable {

    private int id;
    private String description;
    private Double price;
}
