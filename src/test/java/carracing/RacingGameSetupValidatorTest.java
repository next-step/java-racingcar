package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSetupValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("isNonBlank(): null 또는 \"\"이 입력된 경우 false를 반환한다.")
    void testIsNonBlank(String input) {
        assertThat(RacingGameSetupValidator.isNonBlank(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"null:false", "'':false", "'   ':false", "abcd:false", "-1:false", "0:false", "1.123:false", "1,a12:false", "1:true", "2:true", "10:true"}, nullValues = {"null"}, delimiter = ':')
    @DisplayName("isPositiveInteger(): 양의 정수를 입력한 경우 true 그렇지 않은 경우 false를 반환한다.")
    void testIsPositiveInteger(String input, boolean expected) {
        assertThat(RacingGameSetupValidator.isPositiveInteger(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"null:1:false", "'':1:false", "'   ':10:false", "abc:3:true", "abcde:3:false", "1:4:true"}, delimiter = ':')
    @DisplayName("isValidLengthString(): 문자열이 null 또는 공백 또는 maxLength를 초과하는 경우 false를 그렇지 않은 경우 true를 반환한다.")
    void testIsValidLengthString(String input, int maxLength, boolean expected) {
        assertThat(RacingGameSetupValidator.isValidLengthString(input, maxLength)).isEqualTo(expected);
    }
}