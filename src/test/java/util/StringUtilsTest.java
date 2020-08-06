package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @DisplayName("빈 문자열 여부 확인 테스트 - true인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "               "})
    void isBlank_true_test(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @DisplayName("빈 문자열 여부 확인 테스트 - false인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"test", "1 + 2 + 3 + 4 + 5", "뚜뚜뚜", "            -"})
    void isBlank_false_test(String input) {
        assertFalse(StringUtils.isBlank(input));
    }

    @DisplayName("숫자 형식 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3030:true", "3.1415926:true", "000:true", "OOO:false", "string:false"}, delimiter = ':')
    void validateNumber_test(String input, boolean result) {
        assertThat(StringUtils.validateNumber(input)).isEqualTo(result);
    }

    @DisplayName("String to Number 변환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"200", "0", "-314", "1.42"})
    void getNumber_test(String input) {
        assertThat(StringUtils.getNumber(input)).isEqualTo(Double.parseDouble(input));
    }

    @DisplayName("String to Number 변환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"O", "1O", "훈민정음", "^*^"})
    void getNumber_error_test(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.getNumber(input));
    }

    @DisplayName("반복 문자열 생성 메소드(repeat) 테스트")
    @ParameterizedTest
    @CsvSource(value = {"s,5:sssss", "hi,0:''"}, delimiter = ':')
    void repeat_test(String input, String result) {
        String[] inputArray = input.split(",");
        assertThat(StringUtils.repeat(inputArray[0], Integer.parseInt(inputArray[1])))
                .isEqualTo(result);
    }
}