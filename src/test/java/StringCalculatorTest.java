import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
    @DisplayName("숫자 하나를 문자로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    void inputOneStringTest() {
        // given
        StringCalculator stringCalculator = new StringCalculator("1");

        // when
        // then
        assertThat(stringCalculator.calc()).isEqualTo(1);
    }

    @DisplayName("빈 문자열은 또는 null은 0을 반환한다.")
    @Test
    void inputBlankTest() {
        assertAll(
                () -> assertThat(new StringCalculator("").calc()).isEqualTo(0),
                () -> assertThat(new StringCalculator(null).calc()).isEqualTo(0));
    }

    @DisplayName("음수를 전달할 경우 예외가 발생한다.")
    @Test
    void inputNegativeNumThrowExceptionTest() {
        assertThatThrownBy(() -> new StringCalculator("-1:2:3").calc()).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("쉼표 또는 콜론을 구분자로 분리한 각 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void delimitersSumTest(String argument) {
        // given
        StringCalculator stringCalculator = new StringCalculator(argument);

        // when
        // then
        assertThat(stringCalculator.calc()).isEqualTo(6);
    }
}
