package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_커스텀_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void splitAndSum_숫자_아닌_값() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,b,c"))
                .isInstanceOf(RuntimeException.class);
    }
}
