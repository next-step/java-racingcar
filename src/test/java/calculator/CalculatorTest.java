package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }
}
