package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @Test
    @DisplayName("RacingCar가 움직였는지 확인한다.")
    void is_move() {
        RacingCar car = new RacingCar(new RacingCarPosition(1));
        RacingCar movedCar = new RacingCar();
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        boolean movable = movableStrategy.isMovable();
        if (movable) {
            movedCar.move(movableStrategy);
        }

        assertThat(car).isEqualTo(movedCar);
    }

}
