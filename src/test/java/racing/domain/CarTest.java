package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveTest() {
        Car car = new Car("test");
        car.moveOrStop(4);
        assertThat(
                car.getPosition()
        ).isEqualTo(2);
    }
}