package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void plus() {
        int result = Operator.PLUS.apply(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minus() {
        int result = Operator.MINUS.apply(5, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        int result = Operator.MULTIPLY.apply(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        int result = Operator.DIVIDE.apply(5, 3);
        assertThat(result).isEqualTo(1);
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }
    static Stream<String> notOperationSymbols() {
        return Stream.of("@", "^", "%", "f");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 + 2 * 3 / 4:2"}, delimiter = ':')
    @DisplayName("입력값 유효성 검증")
    void validation(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void validationBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(new Number(input).getItem()).isEqualTo(0);
            assertThat(new Symbol(input).getItem()).isEqualTo("");
        });
    }

    @ParameterizedTest
    @MethodSource("notOperationSymbols")
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void validationOperationSymbol(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            assertThat(new Symbol(input).getItem()).isEqualTo(input)
        );
    }

    @Test
    @DisplayName("사칙연산 테스트")
    void calculator() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

}