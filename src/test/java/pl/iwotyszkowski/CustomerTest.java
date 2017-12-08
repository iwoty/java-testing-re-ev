package pl.iwotyszkowski;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setup() {
        this.customer = new Customer(1, "a", "b", 1990, "Male");
    }

    @Test
    void testIfIllegalArgumentExceptionIsThrownAge() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(1, "a", "b", 1889, "Female");
        }, "IllegalArgumentException not thrown when wrong birthyear entered.");
    }

    @Test
    void testIfIllegalArgumentExceptionIsThrownName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(1, "", "b", 1990, "a");
        }, "IllegalArgumentException not thrown when empty name entered.");
    }

    @Test
    void testIfIllegalArgumentExceptionIsThrownGender() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(1, "a", "b", 1990, "a");
        }, "IllegalArgumentException not thrown when wrong gender entered.");
    }

    @Test
    void testGetAge() {
        assertEquals(27, (int) customer.getAge(),
                "Method does not calculate the correct value");
    }
}
