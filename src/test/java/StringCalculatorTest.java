import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("Check action is well actioned")
    @CsvSource({
            "'+', 16",
            "'-', 8",
            "'*', 48",
            "'/', 3"
    })
    void action(String op, int expected) {
        int result = stringCalculator.action(12, 4, op);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void actionShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.action(1, 2, "N")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Check toInt convert string to int well")
    void toInt() {
        int result = stringCalculator.toInt("10");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("Check toInt should throws exception with not number convertable string")
    void toIntShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.toInt("STRING")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("덧셈")
    @Test
    void add() {
        // given & when
        int result = stringCalculator.calculate("2 + 3 + 6");

        // then
        assertThat(result).isEqualTo(11);
    }

    @DisplayName("뺄셈")
    @Test
    void minus() {
        // given & when
        int result = stringCalculator.calculate("5 - 1");

        // then
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("여러 연산이 혼합되어 있는 경우")
    @Test
    void multipleOperation() {
        // given & when
        int result = stringCalculator.calculate("2 + 3 * 4 / 2");

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("입력값이 NULL 일경우 예외를 발생")
    @Test
    void inputNullShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.calculate(null)
        );
    }

    @DisplayName("입력값이 공백일 경우 예외를 발생")
    @Test
    void inputSpaceShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.calculate(" ")
        );
    }

    @DisplayName("입력값이 완성되지 않은 계산식일경우 예외를 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + "})
    void inputWrongFormatShouldThrowException(String s) {
        assertThatThrownBy(
                () -> stringCalculator.calculate(s)
        );
    }

    @DisplayName("0으로 나누려고 시도할경우 예외를 발생")
    @Test
    void divideWithZeroShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.calculate("1 / 0")
        );
    }
}
