package nextstep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NonNegativeIntegerTest {
    static Stream<Arguments> nonNegativeIntegerInputAndResult() {
        return Stream.of(
                Arguments.arguments("1", 1),
                Arguments.arguments("0", 0)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void token_nullAndEmpty(String input) {
        assertThatThrownBy(() -> new Message(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input: {0}, result: {1}")
    @MethodSource("nonNegativeIntegerInputAndResult")
    public void getNumber(String input, int result) {
        assertThat(new NonNegativeInteger(input).getNumber()).isEqualTo(result);
    }

    @Test
    public void text_negative() {
        Assertions.assertThatThrownBy(() -> new NonNegativeInteger("-1"))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
