package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(0);
    }

     @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_여러자리숫자() {
        int result = StringAddCalculator.calculate("102,222");
        assertThat(result).isEqualTo(324);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_not_number() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("!@$$,12,as"))
                .isInstanceOf(RuntimeException.class);
    }
}
