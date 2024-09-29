package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("임계값 이상의 숫자를 넘기면 레이싱카는 움직인다.")
    void testMove() {
        final int overMoveThreshold = RacingCar.MOVE_THRESHOLD + 1;
        final RacingCar racingCar = new RacingCar(1);
        assertThat(racingCar.move(overMoveThreshold)).isTrue();
    }

    @Test
    @DisplayName("임계값 이하의 숫자를 넘기면 레이싱카는 움직이지 않는다.")
    void testNotMove() {
        final int underMoveThreshold = RacingCar.MOVE_THRESHOLD - 1;
        final RacingCar racingCar = new RacingCar(1);
        assertThat(racingCar.move(underMoveThreshold)).isFalse();
    }

    @Test
    @DisplayName("아이디가 동일하다면 동일객체로 간주한다.")
    void testEquals() {
        final Map<RacingCar, Integer> map = new HashMap<>();
        final RacingCar racingCar1 = new RacingCar(1);
        final RacingCar racingCar2 = new RacingCar(1);

        map.put(racingCar1, 0);
        map.put(racingCar2, 2);

        assertThat(map).hasSize(1);
        assertThat(map.get(racingCar1)).isEqualTo(2);
    }
}