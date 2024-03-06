package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String source) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(0);
    }

    private static Stream<Arguments> sourceAndExpectedResultProvider() {
        return Stream.of(
                Arguments.arguments("1", 1),
                Arguments.arguments("1,2", 3),
                Arguments.arguments("1,2:3", 6),
                Arguments.arguments("//;\n1;2;3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAndExpectedResultProvider")
    void splitAndSum(String source, int expected) {
        int result = StringAddCalculator.splitAndSum(source);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void negativeValueThrowIllegalArgumentException() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}