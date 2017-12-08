package pl.iwotyszkowski;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import java.util.Calendar;

public class DiscountCalculatorTest {

    private DiscountCalculator discountCalculator;

    @BeforeEach
    void setup() {
        this.discountCalculator = new DiscountCalculator();
    }

    @org.junit.jupiter.api.Test
    void testDiscountIfFemale() {
        Customer femaleCustomer = new Customer(1,"a", "b", 1990, "Female");

        discountCalculator.setCustomer(femaleCustomer);
        double actualDiscount = discountCalculator.calculateDiscount();

        assertEquals(0, actualDiscount);
    }
}