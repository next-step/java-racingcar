package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputParserTest {

    @DisplayName("String input이 Null이거나 Empty일 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void throwExceptionWhenStringNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputParser.checkNullOrEmpty(input);
                });
    }

    @DisplayName("String input이 split됬을 때 배열 길이가 3미만이거나 짝수인 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 2 +", "1 + / 2", "1", "2 +"})
    public void throwExceptionWhenStringLengthIsInvalid(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String[] parsedInput = input.split(" ");
                    InputParser.checkValidLength(parsedInput);
                });
    }

    @DisplayName("String input이 InputParser를 통해 공백 기준으로 정상 split됨")
    @ParameterizedTest
    @MethodSource("mockStringSplit")
    public void getSplitWhenStringIsProper(String input, String[] output) {
        boolean isTrue = Arrays.deepEquals(InputParser.parseInput(input), output);
        assertThat(isTrue).isTrue();
    }

    private static Stream<Arguments> mockStringSplit() {
        return Stream.of(
                Arguments.of("1 + 2 + 3", new String[]{"1", "+", "2", "+", "3"}),
                Arguments.of("1 / 2 * 3 + 35", new String[]{"1", "/", "2", "*", "3", "+", "35"})
        );
    }
}
