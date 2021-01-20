package caculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("계산기 통합 테스트")
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("하나의 연산을 잘 수행하는지 확인인")
    @Test
    void add() {
        // given & when
        double result = stringCalculator.calculate("2 + 3 + 6");

        // then
        assertThat(result).isEqualTo(11);
    }

    @DisplayName("여러개의 연산을 잘 수행하는지 확")
    @Test
    void multipleOperation() {
        // given & when
        double result = stringCalculator.calculate("2 + 3 * 4 / 2");

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("입력값이 NULL 일경우 예외를 발생")
    @Test
    void inputNullShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.calculate(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 공백일 경우 예외를 발생")
    @Test
    void inputSpaceShouldThrowException() {
        assertThatThrownBy(
                () -> stringCalculator.calculate(" ")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 완성되지 않은 계산식일경우 예외를 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + ", "1 + 1 1"})
    void inputWrongFormatShouldThrowException(String s) {
        assertThatThrownBy(
                () -> stringCalculator.calculate(s)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
