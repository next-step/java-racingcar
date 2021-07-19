package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.MessageFactory;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = StringCalculator.create();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "++*/",
            "12345",
            "2 3 42",
            "2 + + * 4 / 2",
            "+ + + + + + /"
    })
    void 비정상_입력_테스트(String param) {
        // given
        String expectedMessage = MessageFactory.getInputErrorMessage();

        // when, then
        Assertions.assertThatThrownBy(() -> calculator.enter(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2:3",
            "4 - 2:2",
            "6 * 2:12",
            "8 / 4:2",
            "2 * 3 / 3 / 2:1",
            "2 + 3 * 4 / 2:10"
    }, delimiter = ':')
    void 정상_동작_테스트(String param, double expected) {
        // given
        calculator.enter(param);

        // when
        double actual = calculator.calculate();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
