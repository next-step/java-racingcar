package calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import type.MessageFactory;

class StringCalculatorTest {
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
        String expectedMessage = MessageFactory.getBadInputMessage();

        // when, then
        Assertions.assertThatThrownBy(() -> calculator.enter(param))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2,계산결과 : 3.0",
            "4 - 2,계산결과 : 2.0",
            "6 * 2,계산결과 : 12.0",
            "8 / 4,계산결과 : 2.0",
            "2 * 3 / 3 / 2,계산결과 : 1.0",
            "2 + 3 * 4 / 2,계산결과 : 10.0"
    }, delimiter = ',')
    void 정상_동작_테스트(String param, String expected) {
        // given
        calculator.enter(param);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        calculator.calculate();

        // then
        String actual = String.valueOf(outputStream);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
