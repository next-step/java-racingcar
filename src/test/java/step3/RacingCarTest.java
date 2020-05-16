package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.ForwardMoveStrategy;
import step3.domain.RacingCar;
import step3.domain.StopMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("ForwardMoveStrategy는 자동차의 position을 1씩 증가시킨다")
    @Test
    void carForwardMovingTest() {
        RacingCar racingCar = RacingCar.create(1);

        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(1);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(2);
        assertThat(racingCar.move(new ForwardMoveStrategy())).isEqualTo(3);
    }

    @DisplayName("StopMoveStrategy는 자동차의 position이 증가하지 않는다")
    @Test
    void carStopMovingTest() {
        RacingCar racingCar = RacingCar.create(1);

        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
        assertThat(racingCar.move(new StopMoveStrategy())).isEqualTo(0);
    }
}
