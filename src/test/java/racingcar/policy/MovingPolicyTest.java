package racingcar.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.policy.fake.FailMovingPolicy;
import racingcar.policy.fake.SuccessMovingPolicy;

import static org.assertj.core.api.Assertions.assertThat;

class MovingPolicyTest {

    private MovingPolicy movingPolicy;

    @DisplayName("이동이 불가능하다.")
    @Test
    void failMoveByPolicy() {
        // given
        movingPolicy = new FailMovingPolicy();

        // when then
        assertThat(movingPolicy.isPossibleMove()).isFalse();

    }

    @DisplayName("이동이 가능하다.")
    @Test
    void successMoveByPolicy() {
        // given
        movingPolicy = new SuccessMovingPolicy();

        // when then
        assertThat(movingPolicy.isPossibleMove()).isTrue();
    }
}