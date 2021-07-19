package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.MessageFactory;

class ArithmeticCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 정상_입력_테스트(final String operator) {
        // given
        Class<ArithmeticCalculator> expected = ArithmeticCalculator.class;

        // when
        ArithmeticCalculator actual = ArithmeticCalculator.from(operator);

        // then
        Assertions.assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void 비정상_입력_테스트() {
        // given
        String abnormalInput = "abnormal";
        String expectedMessage = MessageFactory.getInputErrorMessage();

        // when, then
        Assertions.assertThatThrownBy(() -> ArithmeticCalculator.from(abnormalInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+,2,3,5",
            "-,4,3,1",
            "*,5,5,25",
            "/,6,2,3"
    }, delimiter = ',')
    void 사칙연산_테스트(final String operator, final double e1, final double e2, final double expected) {
        // given
        ArithmeticCalculator arithmeticCalculator = ArithmeticCalculator.from(operator);

        // when
        Double actual = arithmeticCalculator.operation(e1, e2);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}