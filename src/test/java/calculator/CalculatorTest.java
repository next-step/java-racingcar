package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 계산기_검증_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "+", "2", "*", "5", "/", "6")));

        Calculator calculator = new Calculator(userInput);

        assertThat(calculator.calculateNumbers()).isEqualTo(2);
    }

    @Test
    void 공백_테스트() {
        String userInput = "   ";

        Console console = new Console();

        assertFalse(console.validateUserInputEmpty(userInput));
    }

    @Test
    void 숫자만_입력_테스트() {
        Console console = new Console();

        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "+", "w", "*", "5", "/", "6")));

        assertFalse(console.validateNumber(userInput));
    }

}