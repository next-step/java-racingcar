package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "12:12",
            "1+2/3:1",
            "2+3-4*4/2:2"}, delimiter = ':')
    public void calculatorReturnsAnswer(String input, int expected){
        assertEquals(calculator.calculate(input), expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1+ 2", "1 +2", " ", "",
            "1,+,2:true", "1,+,2,-,3", "/,2:false", "1+-3"})
    public void calculatorThrowsExceptionsOnInvalidExpression(String input){
        Assertions.assertThatIllegalArgumentException().isThrownBy(()->calculator.calculate(input));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "12:12",
            "1,+,2,/,3:1",
            "2,+,3,-,4,*,4,/,2:2"}, delimiter = ':')
    public void calculatorCoreRuns(String input, int expected){
        List<String> inputList = Arrays.stream(
                input.split(","))
                .collect(Collectors.toList());
        assertEquals(calculator.runCalculator(inputList), expected);
    }
}