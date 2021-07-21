package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FIFOCalculatorTest {

    private FIFOCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new FIFOCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:2", "-1:1:0"}, delimiter = ':')
    @DisplayName("덧셈 연산 테스트")
    void addOperationTest(int num1, int num2, int expect) {
        int result = calculator.add(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "-1:1:-2", "1:-1:2"}, delimiter = ':')
    @DisplayName("뺄셈 연산 테스트")
    void subtractOperationTest(int num1, int num2, int expect) {
        int result = calculator.subtract(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "1:0:0", "1:-1:-1"}, delimiter = ':')
    @DisplayName("곱셈 연산 테스트")
    void multiplyOperationTest(int num1, int num2, int expect) {
        int result = calculator.multiply(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "0:1:0", "1:-1:-1"}, delimiter = ':')
    @DisplayName("나눗셈 연산 테스트")
    void divideOperationTest(int num1, int num2, int expect) {
        int result = calculator.divide(num1, num2);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("입력 값이 null 이거나 공백 문자인 경우 테스트")
    void nullOrBlankInputTest() {
        try {
            Field privateField = calculator.getClass().getDeclaredField("rawInput");

            privateField.setAccessible(true);
            privateField.set(calculator, null);

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> calculator.validateInput());

            privateField.set(calculator, "");

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> calculator.validateInput());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("입력 값이 허용되지 않은 기호를 포함하는 경우 테스트")
    void unexpectedInputStringTest() {
        try {
            Field privateField = calculator.getClass().getDeclaredField("rawInput");

            privateField.setAccessible(true);

            privateField.set(calculator, "1 & 1 + 1 = 1");

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> calculator.validateInput());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
