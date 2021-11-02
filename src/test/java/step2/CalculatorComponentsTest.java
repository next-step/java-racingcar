package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.model.CalculatorComponents;
import step2.model.Operator;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorComponentsTest {

    @DisplayName("add method test")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2","100 + 100:200"},delimiter = ':')
    public void add(String str, int result ) {
        String[] inputSplit = str.split(" ");
        CalculatorComponents calculator = new CalculatorComponents();
        assertEquals(calculator.add(inputSplit[0], inputSplit[2]),result);
    }

    @DisplayName("minus method test")
    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0","5 - 10:-5"},delimiter = ':')
    public void minus(String str, int result ) {
        String[] inputSplit = str.split(" ");
        CalculatorComponents calculator = new CalculatorComponents();
        assertEquals(calculator.minus(inputSplit[0], inputSplit[2]),result);
    }

    @DisplayName("multiply method test")
    @ParameterizedTest
    @CsvSource(value = {"5 * 5:25","9 * 12:108"},delimiter = ':')
    public void multiply(String str, int result ) {
        String[] inputSplit = str.split(" ");
        CalculatorComponents calculator = new CalculatorComponents();
        assertEquals(calculator.multiply(inputSplit[0], inputSplit[2]),result);
    }

    @DisplayName("divide method test")
    @ParameterizedTest
    @CsvSource(value = {"1 / 1:1","5 / 1:5"},delimiter = ':')
    public void divide(String str, int result ) {
        String[] inputSplit = str.split(" ");
        CalculatorComponents calculator = new CalculatorComponents();
        assertEquals(calculator.divide(inputSplit[0], inputSplit[2]),result);
    }

    @DisplayName("divide method test")
    @ParameterizedTest
    @CsvSource(value = {"1 / 1 + 5:6","5 / 1:5"},delimiter = ':')
    public void operator(String str, int result ) {
        Operator operator = new Operator();
        assertEquals(operator.calculator(str),result);
    }


}
