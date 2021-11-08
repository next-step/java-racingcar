package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {

    StringCalculator calculator = new StringCalculator();


    @Test
    @DisplayName("덧셈 테스트")
    void Add() {
        int result = calculator.calculateInfo("2 + 3");
        assertThat(result).isEqualTo(5);
    }


    @Test
    @DisplayName("뺄셈 테스트")
    void Minus() {
        int result = calculator.calculateInfo("3 - 2");
        assertThat(result).isEqualTo(1);
    }


    @Test
    @DisplayName("나눗셈 테스트")
    void Division() {
        int result = calculator.calculateInfo("6 / 3");
        assertThat(result).isEqualTo(2);
    }


    @Test
    @DisplayName("곱셈 테스트")
    void Multiplication() {
        int result = calculator.calculateInfo("2 * 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("사칙연산 테스트")
    void Arithmetic() {
        int result = calculator.calculateInfo("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "4 % 2"})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우, 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void inputNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.validate(input);
        });
    }
}
