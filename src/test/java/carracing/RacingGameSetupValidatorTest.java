package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameSetupValidatorTest {
    @ParameterizedTest
    @CsvSource(value = {"null:false", "'':false", "'   ':false", "abcd:false", "-1:false", "0:false", "1.123:false", "1,a12:false", "1:true", "2:true", "10:true"}, nullValues = {"null"}, delimiter = ':')
    @DisplayName("isPositiveInteger(): 양의 정수를 입력한 경우 true 그렇지 않은 경우 false를 반환한다.")
    void testIsPositiveInteger(String input, boolean expected) {
        assertThat(RacingGameSetupValidator.isPositiveInteger(input)).isEqualTo(expected);
    }
}