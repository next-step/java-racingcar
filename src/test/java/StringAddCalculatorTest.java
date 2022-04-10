import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {
    @NullAndEmptySource
    @ParameterizedTest
    void 빈문자열이거나_null일_경우(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ValueSource(strings = { "1,2", "1:2"})
    @ParameterizedTest
    void 쉼표_콜론_기본구분자(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자는 '//'과 '\n' 사이에 위치하는 문자이다")
    @Test
    void 커스텀_구분자를_사용할_수_있다() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2")).isEqualTo(3);
    }

    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 throw한다")
    @ValueSource(strings = {"-1:2", "//;\n-1;2"})
    @ParameterizedTest
    void 음수(String delimiter) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(delimiter))
                .isInstanceOf(RuntimeException.class);
    }
}
