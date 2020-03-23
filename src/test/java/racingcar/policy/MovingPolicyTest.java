package racingcar.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovingPolicyTest {

    private MovingPolicy movingPolicy;
    private final int IMPOSSIBLE_MOVE_MIN_RANGE = 0;
    private final int IMPOSSIBLE_MOVE_MAX_RANGE = 4;
    private final int POSSIBLE_MOVE_MIN_RANGE = 4;
    private final int POSSIBLE_MOVE_MAX_RANGE = 10;
    private final int REPEAT_COUNT = 1000000;

    @DisplayName("이동이 불가능하다.")
    @Test
    void failMoveByPolicy() {
        // given
        movingPolicy = new MovingPolicy(IMPOSSIBLE_MOVE_MIN_RANGE, IMPOSSIBLE_MOVE_MAX_RANGE);
        int distance = 0;

        // when then
        for (int i = 0; i < REPEAT_COUNT; i++) {
            distance = movingPolicy.distance();
            assertThat(distance).isLessThan(IMPOSSIBLE_MOVE_MAX_RANGE);
            assertThat(movingPolicy.isPossibleMove(distance)).isTrue();
        }
    }

    @DisplayName("이동이 가능하다.")
    @Test
    void successMoveByPolicy() {
        // given
        movingPolicy = new MovingPolicy(POSSIBLE_MOVE_MIN_RANGE, POSSIBLE_MOVE_MAX_RANGE);
        int distance = 0;

        // when then
        for (int i = 0; i < REPEAT_COUNT; i++) {
            distance = movingPolicy.distance();
            assertThat(distance).isBetween(POSSIBLE_MOVE_MIN_RANGE, POSSIBLE_MOVE_MAX_RANGE);
            assertThat(movingPolicy.isPossibleMove(distance)).isTrue();
        }
    }
}