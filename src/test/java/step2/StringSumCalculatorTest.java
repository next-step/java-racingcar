package step2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSumCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        assertThat(StringSumCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringSumCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나()  {
        assertThat(StringSumCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        assertThat(StringSumCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        assertThat(StringSumCalculator.splitAndSum("1,2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() {
        assertThat(StringSumCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() ->
                StringSumCalculator.splitAndSum("-1,2,3")
        ).isInstanceOf(RuntimeException.class);
    }
}