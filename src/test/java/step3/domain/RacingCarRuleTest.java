package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
    void moveTest(int movingCondition, boolean expected) {
        RacingCarRule rule = new RacingCarRule();
        assertThat(rule.canMove(movingCondition)).isEqualTo(expected);
    }

}