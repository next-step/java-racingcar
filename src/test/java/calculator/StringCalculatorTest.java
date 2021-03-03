package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"3 + 7"})
    @DisplayName("덧셈 기능이 정상적으로 이뤄지는지 확인한다.")
    void addOperation(String input) {
        int result = stringCalculator.getResult(input);
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 - 3"})
    @DisplayName("뺄셈 기능이 정상적으로 이뤄지는지 확인한다.")
    void minusOperation(String input) {
        int result = stringCalculator.getResult(input);
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7 * 3"})
    @DisplayName("곱셈 기능이 정상적으로 이뤄지는지 확인한다.")
    void multipleOperation(String input) {
        int result = stringCalculator.getResult(input);
        assertThat(result).isEqualTo(21);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12 / 6"})
    @DisplayName("나눗셈 기능이 정상적으로 이뤄지는지 확인한다.")
    void divideOperation(String input) {
        int result = stringCalculator.getResult(input);
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12 / 6 + 3 * 2 - 3"})
    @DisplayName("사칙연산 기능이 정상적으로 이뤄지는지 확인한다.")
    void calculator(String input) {
        int result = stringCalculator.getResult(input);
        assertThat(result).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 에러가 발생한다.")
    void checkIsNullOrBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.isBlankOrNull(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 ^ 3"})
    @DisplayName("사칙연산 기호가 아닌 경우 에러가 발생한다.")
    void checkIsOperation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.isOperation(input);
        });
    }
}