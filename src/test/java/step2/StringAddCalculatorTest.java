package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    @Test
    @DisplayName("빈 문자열일 경우 0 반환")
    void emptyStringTest() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null인 경우 0 반환")
    void nullTest() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자가 없는 경우 숫자를 그대로 반환")
    void noSeparatorTest() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("구분자로 시작되는 경우")
    void startWithSeparatorTest() {
        int result = StringAddCalculator.splitAndSum(":1:2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("한 개의 기본구분자로 분리한 각 숫자의 합을 반환")
    void defaultSplitTest_oneSeparator() {
        int result = StringAddCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("여러 개의 기본구분자로 분리한 각 숫자의 합을 반환")
    void defaultSplitTest_multipleSeparator() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 분리한 각 숫자의 합을 반환")
    void customSplitTest() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀, 기본 구분자로 분리한 각 숫자의 합을 반환")
    void defaultAndcustomSplitTest() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2,3:4");
        assertThat(result).isEqualTo(10);
    }
}