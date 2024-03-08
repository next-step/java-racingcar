package carracing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열을 입력하는 경우 false를 반환한다.")
    void testBlankValidation(String input) {
        assertThat(Validation.isNonBlank(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"null:false", "abcd:false", "-1:false", "0:false", "1.123:false", "1,a12:false", "1:true", "2:true", "10:true"}, nullValues = {"null"}, delimiter = ':')
    @DisplayName("양의 정수를 입력한 경우 true 그렇지 않은 경우 false를 반환한다.")
    void testCharValidation(String input, boolean expected) {
        assertThat(Validation.isPositiveInteger(input)).isEqualTo(expected);
    }


}