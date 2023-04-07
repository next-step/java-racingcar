package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest(name = "문자열을 입력해서 문자열계산기를 생성할 수 있다.")
    @ValueSource(strings = {"1:2", "1,2", "1:2,3", "1,2,3", "1:2:3", "//+\\n1+2+3"})
    void createStringCalculator(String text) {
        assertThatCode(() -> new StringCalculator(text))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "커스텀 구분자를 포함한 문자열을 입력해서 문자열계산기를 생성할 수 있다.")
    @ValueSource(strings = {"//+\\n1+2+3", "//-\\n1-2-3", "//;\\n1;2;3", "//;\\n1;2;3"})
    void createStringCalculatorWithCustomDelimiter(String text) {
        assertThatCode(() -> new StringCalculator(text))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "구분자가 없는 문자열을 입력해서 문자열계산기를 생성할 수 없다.")
    @ValueSource(strings = {"/+\n1+2+3", "ABC+\n22"})
    void createStringCalculatorWithInvalidText(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(text)).withMessage("구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.")
    @ValueSource(strings = {"1,2A,3", "AA12:2:3", "//A\n1A22:3BB"})
    void createStringCalculatorWithInvalidText2(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(text))
                .withMessage("구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "입력한 문자열의 합을 구할 수 있다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "//+\\n1+2+3", "//{\\n1{2,3", "//}\\n1}2:3", "//(\\n1(2:3", "//)\\n1)2:3", "//[\\n1[2:3", "//]\\n1]2:3", "//A\\n1A2:3"})
    void sumTest(String text) {
        int expectedSum = 6;
        final StringCalculator stringCalculator = new StringCalculator(text);

        assertThat(stringCalculator.sum()).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "음수를 입력할 수 없다.")
    @ValueSource(strings = {"1:-2", "-1,2", "//+\\n1+-2+3"})
    void negativeNumbersNotAvailable(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator(text))
                .withMessage("음수를 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "null 이나 빈문자의 계산값은 0 이다.")
    @ValueSource(strings = {"  ", ""})
    void nullOrEmptyStringIsZero(String text) {
        int expectedSum = 0;

        assertThat(new StringCalculator(text).sum()).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "구분자 없이 숫자인 하나의 문자만 입력된다면 계산값은 입력한 값이다.")
    @ValueSource(strings = {"1", "20"})
    void onlyOneStringWithoutOperator(String text) {
        int expectedSum = Integer.parseInt(text);

        assertThat(new StringCalculator(text).sum()).isEqualTo(expectedSum);
    }
}