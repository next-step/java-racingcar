package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.RandomFactory;

class CarTest {

    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveTest() {
        final Car car = new Car("test");
        final int prevPosition = car.getPosition();
        final Random moveRandom = RandomFactory.createMoveRandom(car.getCriterion());
        car.move(moveRandom);
        assertThat(car.getPosition()).isEqualTo(prevPosition + 1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는 경우")
    void stopTest() {
        final Car car = new Car("test");
        final int prevPosition = car.getPosition();
        final Random notMoveRandom = RandomFactory.createNotMoveRandom(car.getCriterion());
        car.move(notMoveRandom);
        assertThat(car.getPosition()).isEqualTo(prevPosition);
    }

}