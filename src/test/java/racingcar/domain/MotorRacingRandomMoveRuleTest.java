package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class MotorRacingRandomMoveRuleTest {

    private static final MotorRacingRandomMoveRule MOTOR_RACING_RANDOM_MOVE_RULE = new MotorRacingRandomMoveRule();

    @DisplayName("전진하는 조건이 0에서 9 사이인지 테스트함")
    @RepeatedTest(100)
    void raceRangeTest() {
        int raceConditionRange = MOTOR_RACING_RANDOM_MOVE_RULE.getRaceConditionRange();
        System.out.println(raceConditionRange);
        assertThat(raceConditionRange).isBetween(0, 9);
    }
}