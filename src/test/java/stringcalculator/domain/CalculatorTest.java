package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import stringcalculator.domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void operatorTest() {
        final List<String> userInput = new ArrayList<>(Arrays.asList("1","+","2","-","1"));
        Calculator calculator = Calculator.of(userInput);
        int result = calculator.getResult();
        Assertions.assertThat(result).isEqualTo(2);
    }
}