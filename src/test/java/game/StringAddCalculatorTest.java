package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    public void splitAndSum_숫자하나(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    public void splitAndSum_쉼표구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3"})
    public void splitAndSum_negative(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input)).isInstanceOf(RuntimeException.class);
    }
}
