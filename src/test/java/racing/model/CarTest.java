package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @Test
    @DisplayName("자동차가 움직이는 경우")
    void go() {
        // given
        int firstLocation = 10;
        car = new Car(1, firstLocation);

        // when
        car.go(true);

        // then
        assertThat(car.getLocation()).isEqualTo(firstLocation + 1);
    }

    @Test
    @DisplayName("자동차가 움직이지 않는 경우")
    void go_when_stop() {
        // given
        int firstLocation = 5;
        car = new Car(1, firstLocation);

        // when
        car.go(false);

        // then
        assertThat(car.getLocation()).isEqualTo(firstLocation);
    }
}