import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자에 대한 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("일반적인 케이스에 대한 splitAndSum 메소드 테스트")
    @ParameterizedTest(name = "{index} {displayName} value={0}")
    @MethodSource("getTestTextAndExpectedResult")
    public void testSplitAndSum(String text, Integer expected) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> getTestTextAndExpectedResult() {
        return Stream.of(
            Arguments.of("1", 1),
            Arguments.of("1,2", 3),
            Arguments.of("1,2:3", 6),
            Arguments.of("//;\n1;2;3", 6)
        );
    }

    @DisplayName("음수에 대한 예외 테스트")
    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}

