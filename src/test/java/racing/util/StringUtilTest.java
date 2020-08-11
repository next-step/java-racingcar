package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @DisplayName("반복 문자열 생성 확인")
    @ParameterizedTest
    @CsvSource({"5, -, -----", "3, a, aaa", "1, b, b"})
    void makeRepeatString(ArgumentsAccessor argumentsAccessor) {
        int length = argumentsAccessor.getInteger(0);
        String element = argumentsAccessor.getString(1);
        String expected = argumentsAccessor.getString(2);

        assertThat(StringUtil.makeRepeatString(length, element)).isEqualTo(expected);
    }
}