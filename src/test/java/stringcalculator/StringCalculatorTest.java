package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class StringCalculatorTest {

    @DisplayName("문자열을 입력해서 문자열계산기를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = "123")
    void createStringCalculator(String text) {

        assertThatCode(() -> {
            final StringCalculator stringCalculator = new StringCalculator(text);
        }).doesNotThrowAnyException();
    }

}