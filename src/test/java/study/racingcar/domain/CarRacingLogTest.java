package study.racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-22
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class CarRacingLogTest {
    @Test
    void getCar() {
        Car car = new Car("car1");
        CarRacingLog carRacingLog = new CarRacingLog(car, 1);

        assertThat(carRacingLog.getCar()).isEqualTo(car);
    }

    @Test
    void getPosition() {
        Car car = new Car("car1");
        final int position = 2;
        CarRacingLog carRacingLog = new CarRacingLog(car, position);

        assertThat(carRacingLog.getPosition()).isEqualTo(position);
    }
}
