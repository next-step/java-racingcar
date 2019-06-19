package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 이동하는지 확인한다")
    void checkCarIsMoving() {
        // given
        RacingCar racingCar = RacingCar.of("blue", new MockCarEngine(true));
        // when
        int position = racingCar.tryMove().getPosition();
        // then
        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는것을 확인한다")
    void checkCarDoesNotMove() {
        // given
        RacingCar racingCar = RacingCar.of("blue", new MockCarEngine(false));
        // when
        int position = racingCar.tryMove().getPosition();
        // then
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 위치를 정상적으로 비교하는지 확인한다")
    void checkPositionOfCarIsNormallyCompared() {
        // given
        RacingCar racingCar1 = RacingCar.of("blue", new MockCarEngine(true));
        racingCar1.tryMove().tryMove().tryMove();

        RacingCar racingCar2 = RacingCar.of("red", new MockCarEngine(true));
        racingCar2.tryMove().tryMove();

        // when
        int compare = racingCar1.compareTo(racingCar2);
        // then
        assertThat(compare).isEqualTo(1);
    }
}
