import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @DisplayName(value = "입력값이 빈 문자열이거나 null 이라면 isBlank 함수를 호출했을 때 true 를 반환한다.")
    @Test
    void isBlank_ShouldReturnTrueForNullOrBlankStrings() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.isBlank(" ");
        });
    }

    @DisplayName(value = " + , - , * , / 외의 연산자를 입력하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void operatorTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "5 ! 0";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        });
    }

    @DisplayName(value = "두 숫자를 더할 수 있다.")
    @Test
    void additionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1 + 3";

        assertThat(stringCalculator.calculate(input)).isEqualTo(4);
    }

    @DisplayName(value = "두 숫자를 뺄 수 있다.")
    @Test
    void subtractionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "4 - 1";

        assertThat(stringCalculator.calculate(input)).isEqualTo(3);
    }

    @DisplayName(value = "두 숫자를 곱할 수 있다.")
    @Test
    void multiplyTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "2 * 4";

        assertThat(stringCalculator.calculate(input)).isEqualTo(8);
    }

    @DisplayName(value = "두 숫자를 나눌 수 있다.")
    @Test
    void divisionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "6 / 3";

        assertThat(stringCalculator.calculate(input)).isEqualTo(2);
    }

    @DisplayName(value = "0으로 나누면 IllegalArgumentException을 발생시킨다.")
    @Test()
    void should_ThrowException_When_dividedByZero() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "5 / 0";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculate(input);
        });
    }
}
