package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("정상적인 사칙연산자는 예외가 발생하지 않는 Test")
    @ParameterizedTest
    @CsvSource({"*, *", "+, +", "-, -", "/, /"})
    public void acceptProperOperators(String inputOperator, String expectedOperator) {
        assertEquals(Operator.getOperator(inputOperator).getValue(), expectedOperator);
    }

    @DisplayName("비정상적인 사칙연산자는 IllegalArgumentException이 발생하는 Test")
    @ParameterizedTest
    @ValueSource(strings = {"++", "123", "1", "--", "!*"})
    public void throwExceptionWhenNotProperOperators(String inputOperator) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operator.getOperator(inputOperator);
                });
    }

}