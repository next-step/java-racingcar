package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null과 빈값은 0을 리턴한다")
    void splitAndSum_null_빈값() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("값을 하나 입력하면 그 값이 그대로 리턴된다")
    void splitAndSum_값하나() {
        int result = StringAddCalculator.splitAndSum("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void splitAndSum_두개의값() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);

        result = StringAddCalculator.splitAndSum("2:3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void splitAndSum_세개의값() {
        int result = StringAddCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("2:3:1");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);

        result = StringAddCalculator.splitAndSum("1:3,4");
        assertThat(result).isEqualTo(8);
    }

    @Test
    void splitAndSum_커스텀() {
        int result = StringAddCalculator.splitAndSum("//&\n1&2&3");
        assertThat(result).isEqualTo(6);
    }
}