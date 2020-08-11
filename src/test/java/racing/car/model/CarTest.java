package racing.car.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private racing.car.model.Car car;

    @Test
    @DisplayName("자동차가 움직이는 경우")
    void go() {
        // given
        int firstLocation = 10;
        car = new racing.car.model.Car(1, firstLocation);

        // when
        car.go();

        // then
        assertThat(car.getLocation()).isEqualTo(firstLocation + 1);
    }
}