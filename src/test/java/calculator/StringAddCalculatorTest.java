package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest
{
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String value)
    {
        int result = StringAddCalculator.splitAndSum(value);
        assertThat(result).isZero();
    }

    @Test
    void splitAndSum_숫자하나()
    {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자()
    {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자()
    {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자()
    {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative()
    {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void splitAndSum_문자만()
    {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("abcdefg"))
            .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void splitAndSum_십의자리숫자()
    {
        int result = StringAddCalculator.splitAndSum("//;\n20;2;30");
        assertThat(result).isEqualTo(52);
    }

}
