package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {

    StringCalculator calculator = new StringCalculator();


    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "4 + 1"})
    void Add(String input) {
        int result = calculator.calculateInfo(input);
        assertThat(result).isEqualTo(5);
    }


    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"6 - 5", "4 - 3"})
    void Minus(String input) {
        int result = calculator.calculateInfo(input);
        assertThat(result).isEqualTo(1);
    }


    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"6 / 3", "4 / 2"})
    void Division(String input) {
        int result = calculator.calculateInfo(input);
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3", "6 * 1"})
    void Multiplication(String input) {
        int result = calculator.calculateInfo(input);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void Arithmetic(String input) {
        int result = calculator.calculateInfo(input);
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
