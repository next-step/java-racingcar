package stydy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("split and sum test for null and empty")
    public void splitAndSum_null_또는_빈문자() {
        int result = Calculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("split and sum test for one number")
    public void splitAndSum_숫자하나() throws Exception {
        int result = Calculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("split and sum test for separator ','")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = Calculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("split and sum test for separator ',|:'")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = Calculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("split and sum test for custom separator")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("split and sum test for negative number")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> Calculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}