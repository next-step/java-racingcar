package calculator;

import static calculator.StringCalculator.splitAndCalculate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    /**
     assertAll() : 여러 assertion을 모두 실행한 후, 통과하지 못한 모든 assertion을 함께 화면에 출력해 줌
         - assertThat() 을 여러 개 사용할 때는 하나의 실패에 대해서만 화면에 출력해 줌
     */
    @Test
    void null_or_empty() {
        assertAll(
            () -> assertThat(splitAndCalculate(null, "+")).isZero(),
            () -> assertThat(splitAndCalculate("", "+")).isZero()
        );
    }

    @Test
    void single_number_value() {
        assertThat(splitAndCalculate("1", "+")).isEqualTo(1);
    }

    @Test
    void string_with_comma() {
        assertThat(splitAndCalculate("1,2", "+")).isEqualTo(3);
    }

    @Test
    void string_with_colon() {
        assertThat(splitAndCalculate("1,2:3", "+")).isEqualTo(6);
    }

    @Test
    void string_with_custom_separator() {
        assertThat(splitAndCalculate("//;\n1;2;3", "+")).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2", "#$ek", "2-9"})
    void wrong_string_value(String input) {
        assertThatThrownBy(() -> splitAndCalculate(input, "+")).
            isInstanceOf(RuntimeException.class).
            hasMessage("허용하지 않는 값이 존재합니다.");
    }
}
