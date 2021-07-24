package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        String input = "2 + 3";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus() {
        String input = "3 - 1";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiple() {
        String input = "3 * 2";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        String input = "6 / 2";
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(3);
    }
}