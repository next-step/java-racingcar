package test2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        Positive result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(new Positive(0));

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(new Positive(0));
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        Positive result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(new Positive(1));
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        Positive result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new Positive(3));
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        Positive result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        Positive result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new Positive(6));
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
