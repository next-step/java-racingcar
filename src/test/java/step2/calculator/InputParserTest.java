package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

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

    /*
    string input이 split됬을 때 최소 필요조건인 "숫자1", "연산자", "숫자2"  == 배열 길이 3이상
    항상 split된 string 배열은 길이가 홀수여야 함.
     */
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
    @ValueSource(strings = {"1 + 2 + 3", "1 / 2 * 3", "1 * 4 / 3 + 2 + 34"})
    public void getSplitWhenStringIsProper(String input) {
        assertThat(Arrays.deepEquals(input.split(" "), InputParser.parseInput(input)))
                .isTrue();
    }
}
