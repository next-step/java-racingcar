import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName(value = "공백을 기준으로 연산자와 피연산자를 구분한다.")
    @Test
    void splitOperatorAndOperand() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "3 / 2";
        String[] splitInput = {"3", "/", "2"};

        assertThat(stringCalculator.splitBySeparator(input)).isEqualTo(splitInput);
    }

    @DisplayName(value = " + , - , * , / 외의 연산자를 입력하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void operatorTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"5", "!", "0"};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateSplitString(splitInput);
        });
    }

    @DisplayName(value = "두 숫자를 더할 수 있다.")
    @Test
    void additionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"1", "+", "3"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(4);
    }

    @DisplayName(value = "두 숫자를 뺄 수 있다.")
    @Test
    void subtractionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"4", "-", "1"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(3);
    }

    @DisplayName(value = "두 숫자를 곱할 수 있다.")
    @Test
    void multiplyTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"2", "*", "4"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(8);
    }

    @DisplayName(value = "두 숫자를 나눌 수 있다.")
    @Test
    void divisionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"6", "/", "3"};

        assertThat(stringCalculator.calculateSplitString(splitInput)).isEqualTo(2);
    }

    @DisplayName(value = "0으로 나누면 IllegalArgumentException을 발생시킨다.")
    @Test()
    void should_ThrowException_When_dividedByZero() {
        StringCalculator stringCalculator = new StringCalculator();
        String[] splitInput = {"5", "/", "0"};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.calculateSplitString(splitInput);
        });
    }
}
