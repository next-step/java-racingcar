package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @Test
    @DisplayName("자동차의 경주 기록을 가져온다")
    void car_recrod() {
        Car car = new Car("car", 10);
        RaceRecord raceRecord = car.record();

        assertThat(raceRecord.carName()).isEqualTo(new CarName("car"));
        assertThat(raceRecord.position()).isEqualTo(new Position(10));
    }

    @Test
    @DisplayName("자동차가 이동한다. 이동거리가 1 증가한다")
    public void car_move() {
        Car car = new Car("car", 0);
        car.move();

        assertThat(car.position()).isEqualTo(new Position(1));
    }
}