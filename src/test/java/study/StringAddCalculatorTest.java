package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private  StringAddCalculator StringAddCalculator = new StringAddCalculator();

    @Test
    @DisplayName("Null 빈문자열 체크")
    public void splitAndSum_null_또는_빈문자() {

        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 숫자 1개 int")
    public void splitAndSum_숫자하나()  {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName(",로 구분된 숫자 합")
    public void splitAndSum_쉼표구분자()  {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName(",또는 : 구분된 숫자 합")
    public void splitAndSum_쉼표_또는_콜론_구분자()  {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로또 구분된 숫자 합")
    public void splitAndSum_custom_구분자()  {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수체크")
    public void splitAndSum_negative()  {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}


