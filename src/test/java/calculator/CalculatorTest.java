package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    Calculator calculator;
    int a;
    int b;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        a = 3;
        b = 2;
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void 입력값이_null_이거나_빈_공백_문자일_경우_IllegalArgumentException_throw(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> calculator.calculate(input));
    }

    static Stream<String> blankStrings() {
        return Stream.of("", null);
    }

    @Test
    @DisplayName("더하기 테스트")
    void sum() {
        int actual = calculator.calculate(a + " + " + b);

        assertThat(actual).isEqualTo(a + b);
    }

    @Test
    @DisplayName("빼기 테스트")
    void minus() {
        int actual = calculator.calculate(a + " - " + b);

        assertThat(actual).isEqualTo(a - b);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multi() {
        int actual = calculator.calculate(a + " * " + b);

        assertThat(actual).isEqualTo(a * b);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        int actual = calculator.calculate(a + " / " + b);

        assertThat(actual).isEqualTo(a / b);
    }

    @ParameterizedTest
    @MethodSource("wrongOperation")
    void 사칙연산_기호가_아닌_경우_IllegalArgumentException_throw(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.calculate(input));
    }

    static Stream<String> wrongOperation() {
        return Stream.of("1 ~ 1", "1 ^ 1", "1 ) 1");
    }


}
