import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(" ");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나")
    void numbersTest() {
        int actual = StringAddCalculator.splitAndSum("1");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("컴마 구분자")
    void commaTest() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론 구분자")
    void colonsTest() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    void commaColonsTest() {
        assertThat(StringAddCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    void customDelimiter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
