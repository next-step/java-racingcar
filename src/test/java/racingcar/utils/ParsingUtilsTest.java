package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParsingUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "400:400", "-3:-3", "10000000:10000000"}, delimiter = ':')
    void 문자열숫자_int_파싱(String before, int after) {
        int parsed = ParsingUtils.parseStringToInt(before);
        assertThat(parsed).isEqualTo(after);
    }

    @ParameterizedTest
    @ValueSource(strings = {"thisisnotint", "this also not int!"})
    void 문자열숫자_int_파싱_포멧오류(String input) {
        Assertions.assertThrows(NumberFormatException.class, () ->{
            ParsingUtils.parseStringToInt(input);
        });
    }
}