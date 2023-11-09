package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.RacingCarRule;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"0,false", "3,false", "4,true", "9,true"})
    void moveTest(int movingCondition, boolean expected) {
        RacingCarRule rule = new RacingCarRule();
        assertThat(rule.canMove(movingCondition)).isEqualTo(expected);
    }

}