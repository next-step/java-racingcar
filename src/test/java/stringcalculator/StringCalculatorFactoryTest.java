package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorFactoryTest {
    @DisplayName("커스텀 구분자가 제대로 주어지면 오류가 발생하지 않는다")
    @Test
    void 커스텀_구분자_오류_발생하지_않음() {
        String input = "//;\n1;4;9";

        assertThatNoException()
                .isThrownBy(() -> StringCalculatorFactory.create(input));

    }

    @DisplayName("커스텀 구분자 외의 구분자를 사용하면 않으면 오류가 발생한다")
    @Test
    void 커스텀_구분자_외의_구분자_오류_발생() {
        String input = "//;\n1;4%9";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringCalculatorFactory.create(input))
                .withMessageMatching(StringCalculator.INVALID_EXCEPTION_MESSAGE);
    }

    @DisplayName("커스텀 구분자를 잘못 사용하면 오류가 발생한다")
    @Test
    void 잘못된_커스텀_구분자_오류_발생() {
        String input = "//;\b1;4;9";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringCalculatorFactory.create(input))
                .withMessageMatching(StringCalculator.INVALID_EXCEPTION_MESSAGE);
    }

}
