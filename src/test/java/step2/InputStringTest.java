package step2;

import StringCalculator.InputString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputStringTest {
    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @DisplayName("빈 문자열 에러 발생")
    @ParameterizedTest
    @MethodSource("blankStrings")
    void emptyStringCheckTest(final String str) {
        assertThatThrownBy(() -> {
            new InputString(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백으로 문자열 나누기")
    void splitInputString() {
        final InputString inputString = new InputString("2 + 3");
        assertThat(inputString.getStringList())
                .containsExactly("2", "+", "3");
    }

    @DisplayName("최소 연산 배열 개수 미만 에러 발생")
    @Test
    void checkMinimumArray() {
        assertThatThrownBy(() -> {
            new InputString("2 +");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
