package com.string.calculator;

import com.string.calculator.service.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void calculatorTest() {
        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate("(1+2)"));
    }
}
