package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MovingRuleTest {

    @ParameterizedTest(name = "숫자 {0} 일때 전진 :{1}")
    @CsvSource({"0, false", "1, false", "2, false", "3, false", "4, true", "5, true", "6, true", "7, true", "8, true", "9, true"})
    void 숫자_4_이상일때_전진(int number, boolean expected) {
        MovingRule movingRule = new MovingRule(number);

        assertThat(movingRule.isMoveForward()).isEqualTo(expected);
    }
}
