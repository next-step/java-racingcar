package edu.nextstep.camp.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String nums) {
        int result = StringAddCalculator.splitAndSum(nums);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3:4");
        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n1@2@3"})
    public void splitAndSum_custom_구분자(String nums) {
        int result = StringAddCalculator.splitAndSum(nums);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1;-2~3,200","7,1,2,fd3", "//@\n1@2:3"})
    public void splitAndSum_negative(String nums) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(nums))
                .isInstanceOf(RuntimeException.class);
    }
}
