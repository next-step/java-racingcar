import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 덧셈")
    void plusBiOperand() {
        String input = "1 + 2";
        int plus = calculator.plus(input);

        assertThat(plus).isEqualTo(3);
    }

//    @ParameterizedTest(name = "[{index}] {0} 결과는 {1}")
//    @CsvSource(value = {"1 + 2 + 3:6", "1 + 2 + 3 + 4 + 5:15"}, delimiter = ':')
//    @DisplayName("여러 개의 숫자를 입력 받아 덧셈")
//    void plusTest(String input, int result) {
//        int plus = calculator.plus(input);
//
//        assertThat(plus).isEqualTo(result);
//    }

    @Test
    @DisplayName("두 개의 숫자를 입력받아 뺼셈")
    void minusTwoOperand(){
        String input = "2 - 1";
        int result = calculator.minus(input);

        assertThat(result).isEqualTo(1);
    }

//    @ParameterizedTest(name = "[{index}] {0} 결과는 {1}")
//    @CsvSource(value = {"4:4", "4 - 2 - 1:1", "10 - 1 - 1 - 1 - 2:5"}, delimiter = ':')
//    @DisplayName("여러 개의 숫자를 입력 받아 뺄셈")
//    void minusTest(String input, int expected) {
//        int actual = calculator.minus(input);
//
//        assertThat(actual).isEqualTo(expected);
//    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 곱셈")
    void multiplyBiTest() {
        String input = "2 * 3";

        int result = calculator.multiply(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 나눗셈")
    void divideTest() {
        String input = "4 / 2";

        int result = calculator.divider(input);

        assertThat(result).isEqualTo(2);
    }


}