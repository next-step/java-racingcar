package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomDrivingRuleTest {
    @Test
    void DrivingRule은_싱글턴이다() {
        RandomDrivingRule rule1 = RandomDrivingRule.getInstance();
        RandomDrivingRule rule2 = RandomDrivingRule.getInstance();

        assertThat(rule1 == rule2).isTrue();
    }

    @Test
    void 자동차의_이동가능_여부를_판별하다() {
        RandomDrivingRule randomDrivingRule = RandomDrivingRule.getInstance();

        assertThat(randomDrivingRule.isMovable()).isInstanceOf(Boolean.class);
    }
}