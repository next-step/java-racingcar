package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String input = "1;2;3";
        String delimiter = ";";

        assertThatNoException().isThrownBy(() -> new StringCalculator(input, delimiter));
    }

    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String input = "1;-2;3";
        String delimiter = ";";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new StringCalculator(input, delimiter))
                .withMessageMatching(StringCalculator.INVALID_EXCEPTION_MESSAGE);
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String input = "1:4$%5,6";
        String delimiter = ":|,";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new StringCalculator(input, delimiter))
                .withMessageMatching(StringCalculator.INVALID_EXCEPTION_MESSAGE);
    }

}
