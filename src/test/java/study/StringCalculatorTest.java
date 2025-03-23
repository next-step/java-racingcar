package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 연산 테스트")
    public void testAddition() {
        assertThat(calculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 연산 테스트")
    public void testSubtraction() {
        assertThat(calculator.calculate("5 - 3")).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 연산 테스트")
    public void testMultiplication() {
        assertThat(calculator.calculate("5 * 3")).isEqualTo(15);
    }

    @ParameterizedTest
    @CsvSource({"6 / 3, 2", "10 / 3, 3"})
    @DisplayName("나눗셈 연산 테스트")
    public void testDivision(String expression, int expected) {
        assertThat(calculator.calculate(expression)).isEqualTo(expected);
    }

    @Test
    @DisplayName("여러 연산자가 포함된 수식 테스트")
    public void testMultipleOperations() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("복잡한 수식 테스트")
    public void testComplexExpression() {
        assertThat(calculator.calculate("2 + 3 * 4 + 10 / 2")).isEqualTo(15);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 입력값 테스트")
    public void testEmptyInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input))
                .withMessageContaining("입력값이 null 이거나 빈 공백 문자열입니다");
    }

    @Test
    @DisplayName("잘못된 연산자 테스트")
    public void testInvalidOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.calculate("2 ? 3"))
                .withMessageContaining("지원하지 않는 연산자입니다");
    }

    @Test
    @DisplayName("유효하지 않은 수식 테스트")
    public void testInvalidExpression() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("2 +"))
                .withMessageContaining("연산자 뒤에 피연산자가 없습니다");
    }

    @Test
    @DisplayName("0으로 나누기 연산 테스트")
    public void testDivisionByZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("5 / 0"))
                .withMessageContaining("0으로 나눌 수 없습니다");
    }

    @ParameterizedTest
    @CsvSource({
            "2 + 3, 5",
            "5 - 3, 2",
            "4 * 3, 12",
            "8 / 4, 2",
            "2 + 3 * 4, 20",
            "2 + 3 - 1, 4"
    })
    @DisplayName("다양한 수식 계산 테스트")
    public void testVariousExpressions(final String input, final int expected) {
        assertThat(calculator.calculate(input)).isEqualTo(expected);
    }
}
