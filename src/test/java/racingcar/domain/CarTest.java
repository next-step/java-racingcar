package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        //given

        final int START_LOCATION = 0;
        final int MOVE_STRATEGY = 1;
        final int expectLocation = START_LOCATION + MOVE_STRATEGY;
        Car car = new Car(START_LOCATION);

        //when
        car.move(true);

        //then
        assertThat(car.getCurrentLocation()).isEqualTo(expectLocation);
    }

    @Test
    void getCurrentLocation() {
        //given
        final int NOW_LOCATION = 2;
        Car car = new Car(NOW_LOCATION);

        //when
        int expectLocation = car.getCurrentLocation();
        //then
        assertThat(expectLocation).isEqualTo(NOW_LOCATION);
    }

}
