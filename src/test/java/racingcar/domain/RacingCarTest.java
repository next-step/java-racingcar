package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    @DisplayName("RacingCar가 움직였는지 확인한다.")
    void is_move() {
        RacingCar car = new RacingCar("car1", new RacingCarPosition(1));
        RacingCar movedCar = new RacingCar("car2", new RacingCarPosition(0));
        MovableStrategy movableStrategy = new TrueMovableStrategy();
        movedCar.move(movableStrategy);

        assertThat(car.getStatus()).isEqualTo(movedCar.getStatus());
    }

}
