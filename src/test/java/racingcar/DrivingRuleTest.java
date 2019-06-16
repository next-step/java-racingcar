package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DrivingRuleTest {
    @Test
    void DrivingRule은_싱글턴이다() {
        DrivingRule rule1 = DrivingRule.getInstance();
        DrivingRule rule2 = DrivingRule.getInstance();

        assertThat(rule1 == rule2).isTrue();
    }

    @Test
    void 자동차의_이동가능_여부를_판별하다() {
        DrivingRule drivingRule = DrivingRule.getInstance();

        assertThat(drivingRule.isMovable()).isInstanceOf(Boolean.class);
    }
}