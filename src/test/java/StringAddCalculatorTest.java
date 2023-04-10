import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSumNullOrEmpty(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSumNullOrEmpty(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSumOneNumber("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSumTwoRegex("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
//    @ValueSource(strings = {"//;\n1;2;3"})
    @ValueSource(strings = {"//,\n1,2,3,4"})
    public void splitAndSum_custom_구분자(String input) throws Exception {
        int result = StringAddCalculator.splitAndSumCustom(input);
//        assertThat(result).isEqualTo(6);
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "-5", "dd"})
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSumNotNumber(input))
                .isInstanceOf(RuntimeException.class);
    }

}




