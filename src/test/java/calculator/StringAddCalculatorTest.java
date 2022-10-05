package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_or_splace(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void one_number() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void comma() {
        int result = StringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void comma_or_colon() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 지정")
    void custom_separator() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("예외) 숫자 이외의 값을 전달하는 경우")
    void not_number() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("1,#"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("예외) 수를 전달하는 경우")
    void negative() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}