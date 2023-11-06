package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculatorTest {

    @Test
    void null_또는_빈문자열() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptySource_사용(String input) {
        int actual = Calculator.splitAndSum(input);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        int actual = Calculator.splitAndSum("1");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 숫자_쉼표구분자() {
        int actualOne = Calculator.splitAndSum("1,2");
        int actualTow = Calculator.splitAndSum("1,2,3");
        assertAll(
                () -> assertThat(actualOne).isEqualTo(3),
                () -> assertThat(actualTow).isEqualTo(6)
        );
    }

    @Test
    void 숫자_쉼표_콜론구분자() {
        int actual = Calculator.splitAndSum("1,2:3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 숫자_custom_구분자() {
        int actual = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void 음수값_예외던지기() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("-1,1,2");
        }).isInstanceOf(RuntimeException.class);
    }
}
