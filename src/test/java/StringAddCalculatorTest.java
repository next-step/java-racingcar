import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수가 들어오면 안됩니다.");
    }

    @Test
    public void splitAndSum_잘못된_구분자() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1.2.3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_쉼표_또는_커스텀_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2,3");
        assertThat(result).isEqualTo(6);
    }

}