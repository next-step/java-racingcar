package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void 문자열_분리() {
        String carNamesStr = "red,yellow,blue,pink,purple";
        String[] carNames = StringUtils.spliter(carNamesStr);

        assertThat(carNames.length).isEqualTo(5);
        assertThat(carNames[0]).isEqualTo("red");
        assertThat(carNames[4]).isEqualTo("purple");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void 문자열_분리_NullOrEmpty(String input) {
        Assertions.assertThrows(NullPointerException.class, () -> {
            StringUtils.spliter(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"stringwords:false", "hello:true", "d:true"}, delimiter = ':')
    void 문자열_길이검사(String word, boolean expected) {
        boolean result = StringUtils.isLengthWithinLimits(1, 5, word);
        assertThat(result).isEqualTo(expected);
    }
}