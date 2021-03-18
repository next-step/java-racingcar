package step3.study.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c"})
    @DisplayName("문자열 분리 테스트")
    void splitTest(String str) {
        String[] strArray = {"a", "b", "c"};
        assertThat(StringUtils.split(str, ",")).isEqualTo(strArray);
    }

    @ParameterizedTest
    @CsvSource(value = {"-,3,---", "-,6,------"})
    @DisplayName("반복자 테스트")
    void repeatTest(String str, int num, String result) {
        assertThat(StringUtils.repeat(str, num)).isEqualTo(result);
    }
}
