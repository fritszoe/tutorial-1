package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Car extends Product {
    private String carColor;

    public  Car() {
        super();
    }
}
