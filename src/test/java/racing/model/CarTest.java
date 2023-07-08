package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.utils.MockMoveRandom;
import racing.utils.MockNotMoveRandom;

class CarTest {

    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveTest() {
        final Car car = new Car("test");
        final int prevPosition = car.getPosition();
        final Car moved = car.move(new MockMoveRandom(car.getCriterion()));
        assertThat(moved.getPosition()).isEqualTo(prevPosition + 1);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는 경우")
    void stopTest() {
        final Car car = new Car("test");
        final int prevPosition = car.getPosition();
        final Car stopped = car.move(new MockNotMoveRandom());
        assertThat(stopped.getPosition()).isEqualTo(prevPosition);
    }

}