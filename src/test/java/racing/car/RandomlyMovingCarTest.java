package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomlyMovingCarTest {
    @Test
    @DisplayName("자동차가 무작위로 움직인다.")
    void moveOrStay() {
        Car car = new RandomlyMovingCar();
        int lastLocation = car.getLocation();

        boolean isMoved = false;
        boolean isStayed = false;

        for (int i = 0; i < 100; i++) {
            car.move();

            int currentLocation = car.getLocation();

            isMoved |= lastLocation != currentLocation;
            isStayed |= lastLocation == currentLocation;

            lastLocation = currentLocation;
        }

        assertThat(isMoved && isStayed).isTrue();
    }
}
