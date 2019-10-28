package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step1.OperateCollection.validateProperOperation;
import static step1.Utils.ValidationUtils.isBlankThrowException;
import static step1.Utils.ValidationUtils.isNumeric;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void calculatorTest() {
        String input = "2 + 3 * 4 / 2";

        assertThat(stringCalculator.calculate(input)).isEqualTo(10);
    }

    @Test
    void divideByZeroTest() {
        String input = "2 + 3 * 4 / 0";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$", "%"})
    void validateProperOperationTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            validateProperOperation(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void isBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            isBlankThrowException(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "5"})
    void isNumericTest(String input) {
        assertThat(isNumeric(input)).isEqualTo(true);
    }

    @Test
    void addTest() {
        assertThat(stringCalculator.add(3, 5)).isEqualTo(8);
    }

    @Test
    void substractTest() {
        assertThat(stringCalculator.subtract(8, 3)).isEqualTo(5);
    }

    @Test
    void multiplyTest() {
        assertThat(stringCalculator.multiply(10, 3)).isEqualTo(30);
    }

    @Test
    void divideTest() {
        assertThat(stringCalculator.divide(10, 5)).isEqualTo(2);
    }
}
