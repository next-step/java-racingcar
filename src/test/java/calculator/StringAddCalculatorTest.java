package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StringAddCalculatorTest {
    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 빈 문자열이 들어온 경우, 0을 반환한다")
    void splitAndSum_emptyString() {
        //given
        //when
        int result = StringAddCalculator.splitAndSum("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 메서드의 입력으로 null이 들어온 경우, 0을 반환한다")
    void splitAndSum_null() {
        //given
        //when
        int result = StringAddCalculator.splitAndSum(null);

        //then
        assertThat(result).isEqualTo(0);
    }
}
