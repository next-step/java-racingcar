package step2.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {

    @DisplayName("String input이 Null이거나 Empty일 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @NullAndEmptySource
    public void testThrowExceptionWhenStringNullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.checkNullOrEmpty(input);
                });
    }

    @DisplayName("String input이 parse됬을 때 길이가 3미만이거나 짝수인 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 2 +", "1 + / 2", "1", "2 +"})
    public void testThrowExceptionWhenStringNullOrEmpty2(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String[] parsedInput = input.split(" ");
                    Validator.checkValidLength(parsedInput);
                });
    }
}