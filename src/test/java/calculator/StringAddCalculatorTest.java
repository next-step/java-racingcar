package calculator;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int resultNull = StringAddCalculator.splitAndSum(null);
        int resultBlank = StringAddCalculator.splitAndSum("");
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(resultNull).as("null 테스트").isEqualTo(0);
            softAssertions.assertThat(resultBlank).as("Blank 테스트").isEqualTo(0);
        });
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
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 들어올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1/2,2,3", "1$3,4:5", "//%\n1%%2%%3"})
    public void splitAndSum_숫자형태가_아닌_값(String value) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(value))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 형태가 아닌 값이 존재합니다.");
    }
}