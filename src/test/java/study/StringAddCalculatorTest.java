package study;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setup() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null 또는 빈 문자열 입력시 splitAndSum 체크")
    public void splitAndSum_null_또는_빈문자() {
        int result = stringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = stringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자하나 입력시 splitAndSum 체크")
    public void splitAndSum_숫자하나() throws Exception {
        int result = stringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자 입력시 splitAndSum 체크")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자 입력시 splitAndSum 체크")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("변경 구분자 입력시 splitAndSum 체크")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력시 RuntimeException 체크")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}