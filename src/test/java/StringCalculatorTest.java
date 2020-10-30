import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp () {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("더하기")
    void addition () {
        int result = stringCalculator.addition(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    void subtraction () {
        int result = stringCalculator.subtraction(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기")
    void multiply () {
        int result = stringCalculator.multiply(2, 3);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기")
    void division () {
        int result = stringCalculator.division(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("빈값, 공백 체크 throw IllegalArgumentException")
    @ValueSource(strings = {"", " "})
    void isBlank (String str) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.isNotBlank(str));
    }

    @ParameterizedTest
    @DisplayName("부호 체크 throw IllegalArgumentException")
    @ValueSource(strings = {"1"})
    void isOperator (String operator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.isOperator(operator));
    }

    @ParameterizedTest
    @DisplayName("계산")
    @CsvSource(value = {"1:+:2:3", "3:-:1:2", "4:*:2:8", "6:/:2:3"}, delimiter = ':')
    void isContains(int a, String operator, int b, int result) {
        assertThat(stringCalculator.calculator(a, operator, b)).isEqualTo(result);
    }
}
