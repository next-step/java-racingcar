package step2.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_emptyString() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_oneNumber() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_delimComma() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_delimCommaAndColon() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_delimCustom1() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_delimCustom2() {
        int result = StringAddCalculator.splitAndSum("//-\n1-2-3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3")).isInstanceOf(
            RuntimeException.class);
    }

    @Test
    public void splitAndSum_delimCustomAndNegative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//-\n-1-2-3")).isInstanceOf(
            RuntimeException.class);
    }

    @Test
    public void splitAndSum_blank() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(" ")).isInstanceOf(
            RuntimeException.class);
    }

    @Test
    public void splitAndSum_twoDigits() {
        int result = StringAddCalculator.splitAndSum("11,22:33");
        assertThat(result).isEqualTo(66);
    }
}
