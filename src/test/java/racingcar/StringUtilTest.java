package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.utils.StringUtil;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @ParameterizedTest
    @CsvSource(value = {":true", "'':true", "' ':true", "a:false"}, delimiter = ':')
    @DisplayName("빈문자열 테스트")
    void isBlank(String input, boolean expectedResult) {
        assertThat(StringUtil.isBlank(input)).isEqualTo(expectedResult);
    }

    @Test
    void repeat() {
        String toRepeatString = "-";
        String delimiter = ",";
        int repeatCount = 6;

        String[] resultArray = StringUtil.repeat(toRepeatString + delimiter, repeatCount).split(delimiter);

        assertThat(resultArray.length).isEqualTo(repeatCount);
        Arrays.stream(resultArray).forEach(result -> assertThat(result).isEqualTo(toRepeatString));
    }
}
