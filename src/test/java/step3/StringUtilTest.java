package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilTest {

    @DisplayName("입력받은 숫자 만큼 하이픈 문자열을 반환한다.")
    @Test
    public void printToHyphen_ShouldReturnHyphenString() {
        int inputNumber = 5;
        String expectedValue = "-----";

        String actual = StringUtil.printToHyphen(inputNumber);

        assertThat(actual).isEqualTo(expectedValue);
    }
}
