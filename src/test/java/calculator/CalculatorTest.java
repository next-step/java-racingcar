package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator;
    @BeforeAll
    void initAll () {
        calculator = new Calculator();
    }

    @Test
    void getUserInput() {
        calculator.getUserInput();
        String[] testStrings = {"1", "+", "2"};
//        Assertions.assertThat(calculator.inputStrings).containsAll(testStrings);
    }

}
