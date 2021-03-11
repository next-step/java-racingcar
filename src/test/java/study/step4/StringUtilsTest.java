package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @DisplayName("차량 위치값 문자열(-) 변환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:---", "6:------", "5:-----"}, delimiter = ':')
    void convertIntegerToStringDashTest(int input, String dash) {
        assertThat(StringUtils.convertIntegerToStringDash(input))
                .isEqualTo(dash);
    }
}
