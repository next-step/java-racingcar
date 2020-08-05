import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
         calculator = new StringCalculator();
    }

    @DisplayName("공백 입력 예외 출력")
    @Test
    void emptyTest() {
        assertThatThrownBy(() -> {
            calculator.calculate(" ");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력 값이 null이거나 빈 공백입니다.");
    }

    @DisplayName("null 입력 예외 출력")
    @Test
    void nullTest() {
        assertThatThrownBy(() -> {
            calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백입니다.");
    }

    @DisplayName("잘못된 값 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10 % 5", "1 @ 3"})
    void wrongValueTest(String value) {
        assertThatThrownBy(() -> {
            calculator.calculate(value);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 + 20, 30", "20 + 30, 50"}, delimiter = ',')
    void add(String value, int result) {
        assertThat(calculator.calculate(value)).isEqualTo(result);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 - 20, -10", "30 - 10, 20"}, delimiter = ',')
    void subtract(String value, int result) {
        assertThat(calculator.calculate(value)).isEqualTo(result);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10 * 20, 200", "20 * 30, 600"}, delimiter = ',')
    void multiply(String value, int result) {
        assertThat(calculator.calculate(value)).isEqualTo(result);
    }
    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"20 / 10, 2", "90 / 30, 3"}, delimiter = ',')
    void divide(String value, int result) {
        assertThat(calculator.calculate(value)).isEqualTo(result);
    }

    @DisplayName("0으로 나눌 경우")
    @ParameterizedTest
    @CsvSource(value = {"10 / 0","20 / 0"}, delimiter = ',')
    public void divideTest_by_Zero(String value) {
        assertThatThrownBy(() -> {
            calculator.calculate(value);
        }).hasMessageContaining("0으로 나눌 수 없습니다.");
    }
}