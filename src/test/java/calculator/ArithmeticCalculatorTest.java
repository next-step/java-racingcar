package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.MessageFactory;

@SuppressWarnings("NonAsciiCharacters")
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

    @Test
    void 나누기_0으로_했을_때() {
        // given
        String expectedMessage = "0으로 나눌 수 없습니다.";
        ArithmeticCalculator arithmeticCalculator = ArithmeticCalculator.from("/");

        // when, then
        Assertions.assertThatThrownBy(() -> arithmeticCalculator.operation(5.0, 0.0))
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
