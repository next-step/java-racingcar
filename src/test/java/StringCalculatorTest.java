import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @DisplayName(value = "두 숫자를 더할 수 있다.")
    @Test
    void additionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1 + 3";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(4);
    }

    @DisplayName(value = "두 숫자를 뺄 수 있다.")
    @Test
    void subtractionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "4 - 1";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(3);
    }

    @DisplayName(value = "두 숫자를 곱할 수 있다.")
    @Test
    void multiplyTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "2 * 4";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(8);
    }

    @DisplayName(value = "두 숫자를 나눌 수 있다.")
    @Test
    void divisionTest() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "6 / 3";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(2);
    }

    @DisplayName(value = "세 숫자를 더할 수 있다.")
    @Test
    void additionTest3() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "1 + 3 + 5";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(9);
    }

    @DisplayName(value = "세 숫자를 뺄 수 있다.")
    @Test
    void subtractionTest3() {
        StringCalculator stringCalculator = new StringCalculator();
        String input = "5 - 1 - 1";

        assertThat(stringCalculator.makeResult(input)).isEqualTo(3);
    }
}
