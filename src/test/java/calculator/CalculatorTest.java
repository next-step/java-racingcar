package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    
    @Test
    @DisplayName("빈문자열 또는 null 일 경우 0 값이 나온다")
    void nullAndBlankTest() throws Exception {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력하면 해당 숫자를 반환한다.")
    void numberStringTest() throws Exception {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력 시 두 숫자의 합을 반환한다.")
    void sumStringNumbers() throws Exception {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }
}
