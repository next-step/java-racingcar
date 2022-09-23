package calculator;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void null_or_empty() {
        assertThat(splitAndSum("")).isZero();
    }

    @Test
    void single_number_value() {
        assertThat(splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void string_with_comma() {
        assertThat(splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void string_with_colon() {
        assertThat(splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void string_with_custom_seperator() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void wrong_string_value() {
        assertThatThrownBy(() -> splitAndSum("-1,2")).
            isInstanceOf(RuntimeException.class).
            hasMessage("허용되지 않는 값이 존재합니다.");
    }
}
