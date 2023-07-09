package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 이동하는 경우")
    void moveTest() {
        Car car = new Car("test");

        car.move(1);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차가 이동하지 않는 경우")
    void stopTest() {
        Car car = new Car("test");

        car.move(0);

        assertThat(car.getPosition()).isEqualTo(1);
    }

}
