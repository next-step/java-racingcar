package step2.calculator.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionSeparatorTest {
    @ParameterizedTest
    @MethodSource("generateSampleForSplitMethodTesting")
    void split(final String input, final List<String> expected) {
        // when
        final List<String> result = ExpressionSeparator.split(input);
        
        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generateSampleForSplitMethodTesting() {
        return Stream.of(
                Arguments.of("1 + 1", Arrays.asList("1", "+", "1")),
                Arguments.of("2 - 2", Arrays.asList("2", "-", "2")),
                Arguments.of("3 * 3", Arrays.asList("3", "*", "3"))
        );
    }
}