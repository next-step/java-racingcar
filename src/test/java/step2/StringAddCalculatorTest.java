package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest(name = "전달되는 값이 {arguments}이면 0을 반환한다.")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String value) {
        int result = stringAddCalculator.splitAndSum(value);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 소수점을_가진_값이면_예외를_터트린다() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("1,2.5,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
