package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("입력 값이 공백일 경우 예외")
    @Test
    void inputExceptionTest1() {
        String input = "";
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute(input));
    }

    @DisplayName("입력 값이 null일 경우 예외")
    @Test
    void inputExceptionTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute(null));
    }

    @DisplayName("계산 검증")
    @ParameterizedTest(name = "{index}번째 => {0} 연산결과 : {1}")
    @CsvSource(value = {
            "3 + 4 + 5 - 2 / 4 | 2",
            "3 + 4 - 5 * 2 / 4 | 1",
            "5 / 2 - 3 | -1",
            "2 + 3 * 4 / 2 | 10"
    }, delimiter = '|')
    void calculateTest(String input, Long expected) {
        assertThat(calculator.execute(input)).isEqualTo(expected);
    }

    @DisplayName("잘못된 연산자 예외")
    @ParameterizedTest(name = "{index}번째 => 예외발생")
    @ValueSource(strings = {
            "3 + 4 % 5 - 2 / 4",
            "3 + 4 - 5 * 2 % 4",
            "5 ^ 2 - 3 | -1",
            "2 ^ 3 # 4 / 2"
    })
    void calculateExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.execute(input));
    }

}