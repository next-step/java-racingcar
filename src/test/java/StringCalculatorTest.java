import stringAddCalculator.StringCalculator;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {


    private final StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = stringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_customDelimiter() throws Exception {
        int result = stringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}