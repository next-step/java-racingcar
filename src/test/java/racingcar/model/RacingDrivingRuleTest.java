package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingDrivingRuleTest {
    @Test
    void 자동차의_이동가능_여부를_판별하다() {
        DrivingRule racingDrivingRule = RacingDrivingRule.createDefault();

        assertThat(racingDrivingRule.isMovable()).isInstanceOf(Boolean.class);
    }

    @Test
    void 규칙의_기준값보다_작은값이_생성되면_이동할_수_없다() {
        NumberGenerationStrategy oneLessGenerator = () -> RacingDrivingRule.MOVEMENT_CRITERIA - 1;
        DrivingRule drivingRule = RacingDrivingRule.createWithNumberGenerator(oneLessGenerator);

        assertThat(drivingRule.isMovable()).isFalse();
    }

    @Test
    void 자동차는_규칙의_기준값보다_큰값이_생성되면_이동가능하다() {
        NumberGenerationStrategy oneMoreGenerator = () -> RacingDrivingRule.MOVEMENT_CRITERIA + 1;
        DrivingRule drivingRule = RacingDrivingRule.createWithNumberGenerator(oneMoreGenerator);

        assertThat(drivingRule.isMovable()).isTrue();
    }
}