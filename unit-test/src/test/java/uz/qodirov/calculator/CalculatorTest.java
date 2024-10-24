package uz.qodirov.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void inject() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        Integer sum = calculator.sum(12, 13);
        Assertions.assertEquals(25, sum);
    }
}
