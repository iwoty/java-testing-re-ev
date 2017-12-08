package pl.iwotyszkowski;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SaleTest {
    
    private Sale sale;

    @BeforeEach
    void setup() {
        this.sale = new Sale(1,"a", new BigDecimal("123"), 23);
    }

    @org.junit.jupiter.api.Test
    void testIfIllegalArgumentExceptionIsThrownName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sale(1,"", new BigDecimal("123"), 23);
        }, "IllegalArgumentException not thrown when empty name.");
    }

    @org.junit.jupiter.api.Test
    void testIfIllegalArgumentExceptionIsThrownTaxRate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sale(1, "a", new BigDecimal("123"), 123);
        }, "IllegalArgumentException not thrown when wrong tax rate entered.");
    }

    @org.junit.jupiter.api.Test
    void testIfIllegalArgumentExceptionIsThrownNetValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Sale(1,"a", new BigDecimal("-1"), 12);
        }, "IllegalArgumentException not thrown when wrong net value entered.");
    }

    @org.junit.jupiter.api.Test
    void testGetGrossValue() {
        BigDecimal grossValue = new BigDecimal("151.29");
        assertEquals(grossValue, sale.getGrossValue(),
                "Method does not calculate the gross value correct.");
    }
}