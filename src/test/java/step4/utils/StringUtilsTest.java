package step4.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("null이나 공백일경우 true, 아닐경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {",true", "'',true", "name,false"})
    void isBlank(String name, boolean expected) {
        assertThat(StringUtils.isBlank(name)).isEqualTo(expected);
    }
}