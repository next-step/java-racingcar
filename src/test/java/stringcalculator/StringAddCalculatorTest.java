package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {
    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("빈문자열에 대해서는 0을 반환한다")
    void empty_or_null(String input) {
        assertThat(StringAddCalculator.splitAndAdd( input)).isEqualTo(0);
    }

    @Test
    void splitAndAdd_문자열2개() {
        String input = "1,2";
        int result = StringAddCalculator.splitAndAdd(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndAdd_문자열3개() {
        String input = "1,2,3";
        assertThat(StringAddCalculator.splitAndAdd(input)).isEqualTo(6);
    }

    @Test
    void splitAndAdd_쉼표와콜론을처리한다() {
        String input = "1,2:3";

        assertThat(StringAddCalculator.splitAndAdd(input)).isEqualTo(6);
    }

    @Test
    void splitAndAdd_커스텀구분자를처리한다() {
        String input = "//;\n1;2;3";

        assertThat(StringAddCalculator.splitAndAdd(input)).isEqualTo(6);
    }

    @Test
    void splitAndAdd_숫자이외의문자열은처리할수없다() {
        String input = "zzz";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.splitAndAdd(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndAdd_음수는처리할수없다() {
        String input = "-1";

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.splitAndAdd(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("커스텀구분자를 식별해서 연산을 수행한다")
    void splitAndAdd_커스구분자를식별한다() {
        String input = "//;\n1;2;3;4";

        assertThat(StringAddCalculator.splitAndAdd(input)).isEqualTo(10);
    }
}
