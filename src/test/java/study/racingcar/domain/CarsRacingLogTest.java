package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-22
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class CarsRacingLogTest {
    private CarsRacingLog carsRacingLog;

    @BeforeEach
    void setUp() {
        this.carsRacingLog = new CarsRacingLog();
    }

    @Test
    void add() {
        boolean added = carsRacingLog.add(new CarRacingLog(new Car("car1"), 1));

        assertThat(added).isTrue();
    }

    @Test
    void getCarRacingLogs() {
        carsRacingLog.add(new CarRacingLog(new Car("car1"), 1));
        carsRacingLog.add(new CarRacingLog(new Car("car2"), 2));
        carsRacingLog.add(new CarRacingLog(new Car("car3"), 3));

        assertThat(carsRacingLog.getCarRacingLogs()).size().isEqualTo(3);
    }

    @Test
    void maxPosition() {
        carsRacingLog.add(new CarRacingLog(new Car("car1"), 1));
        carsRacingLog.add(new CarRacingLog(new Car("car2"), 2));
        carsRacingLog.add(new CarRacingLog(new Car("car3"), 3));

        assertThat(carsRacingLog.getMaxPosition()).isEqualTo(3);
    }
}
