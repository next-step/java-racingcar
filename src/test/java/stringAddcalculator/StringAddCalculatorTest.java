package stringAddcalculator;

import calculator.StringAddCalculator;
import calculator.operator.PositiveNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        PositiveNumber result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new PositiveNumber(0));
    }

    @Test
    public void splitAndSum_숫자하나() {
        PositiveNumber result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(new PositiveNumber(1));
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        PositiveNumber result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new PositiveNumber(3));
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        PositiveNumber result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new PositiveNumber(6));
    }

    @Test
    public void splitAndSum_custom_구분자() {
        PositiveNumber result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new PositiveNumber(6));
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}