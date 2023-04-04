package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @DisplayName("빈 문자열 값을 입력 할 경우 0을 반환한다")
    @Test
    void givenEmptyStringWhenInputReturnZero() {
        // given
        String text = "";

        // when
        int result = calculator.input(text);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 값을 입력 할 경우 0을 반환한다")
    @Test
    void givenNullWhenInputReturnZero() {
        // given
        String text = null;

        // when
        int result = calculator.input(text);

        // then
        assertThat(result).isEqualTo(0);
    }
}
