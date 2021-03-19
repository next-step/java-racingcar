package step3.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilTest {

    @DisplayName("하이픈 문자와 5개의 출력해야할 숫자를 입력받아 하이픈 5개의 문자열을 반환한다.")
    @Test
    public void repeat_ShouldReturnHyphenString() {
        int inputNumber = 5;
        String printExpressionStr = "-";
        String expectedValue = "-----";

        String actual = StringUtil.repeat(printExpressionStr, inputNumber);

        assertThat(actual).isEqualTo(expectedValue);
    }
}
