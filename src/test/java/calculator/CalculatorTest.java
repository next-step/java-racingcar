package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void 숫자_입력_예외_테스트() {
        Console console = new Console();

        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "+", "w", "*", "5", "/", "6")));

        assertFalse(console.validateNumber(userInput));
    }

    @Test
    void 덧셈_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "+", "2")));

        Calculator calculator = new Calculator(userInput);

        assertThat(calculator.calculateNumbers()).isEqualTo(3);
    }

    @Test
    void 뺄셈_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "-", "2")));

        Calculator calculator = new Calculator(userInput);

        assertThat(calculator.calculateNumbers()).isEqualTo(-1);
    }

    @Test
    void 곱셈_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "*", "2")));

        Calculator calculator = new Calculator(userInput);

        assertThat(calculator.calculateNumbers()).isEqualTo(2);
    }

    @Test
    void 나눗셈_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "/", "2")));

        Calculator calculator = new Calculator(userInput);

        assertThat(calculator.calculateNumbers()).isEqualTo(0);
    }

    @Test
    void 나눗셈_예외_테스트() {
        List<String> userInput = new ArrayList<>(
            (Arrays.asList("1", "/", "0")));

        Calculator calculator = new Calculator(userInput);

        assertThatThrownBy(calculator::calculateNumbers)
            .isInstanceOf(IllegalArgumentException.class);
    }
}