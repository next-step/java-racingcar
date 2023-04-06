package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("문자열을 입력해서 문자열계산기를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1:2", "1,2", "1:2,3", "1,2,3", "1:2:3", "//+\n1+2+3"})
    void createStringCalculator(String text) {
        assertThatCode(() -> new StringCalculator(text))
                .doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자를 포함한 문자열을 입력해서 문자열계산기를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"//+\n1+2+3", "//-\n1-2-3", "//;\n1;2;3"})
    void createStringCalculatorWithCustomDelimiter(String text) {
        assertThatCode(() -> new StringCalculator(text))
                .doesNotThrowAnyException();
    }

    @DisplayName("구분자가 없는 문자열을 입력해서 문자열계산기를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"/+\n1+2+3", "ABC+\n22"})
    void createStringCalculatorWithInvalidText(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(text)).withMessage("구분자가 포함되어 있지 않습니다.");
    }
}