import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 덧셈")
    void plusBiOperand() {
        int plus = calculator.plus(1, 2);

        assertThat(plus).isEqualTo(3);
    }

//    @ParameterizedTest(name = "[{index}] {0} 결과는 {1}")
//    @CsvSource(value = {"1 + 2 + 3:6", "1 + 2 + 3 + 4 + 5:15"}, delimiter = ':')
//    @DisplayName("여러 개의 숫자를 입력 받아 덧셈")
//    void plusTest(String input, int result) {
//        int plus = calculator.plus(input);
//
//        assertThat(plus).isEqualTo(result);
//    }

    @Test
    @DisplayName("두 개의 숫자를 입력받아 뺼셈")
    void minusTwoOperand(){
        int result = calculator.minus(2, 1);

        assertThat(result).isEqualTo(1);
    }

//    @ParameterizedTest(name = "[{index}] {0} 결과는 {1}")
//    @CsvSource(value = {"4:4", "4 - 2 - 1:1", "10 - 1 - 1 - 1 - 2:5"}, delimiter = ':')
//    @DisplayName("여러 개의 숫자를 입력 받아 뺄셈")
//    void minusTest(String input, int expected) {
//        int actual = calculator.minus(input);
//
//        assertThat(actual).isEqualTo(expected);
//    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 곱셈")
    void multiplyBiTest() {
        int result = calculator.multiply(2, 3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("두 개의 숫자를 입력 받아 나눗셈")
    void divideTest() {
        int result = calculator.divider(4, 2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함하는 연산 테스트")
    void calculateTest() {
        String input = "1 * 4 - 2 + 3 / 5";
        int expected = 1;

        int actual = calculator.calculate(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void throwTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

}