package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.engine.FixedStopPowerEngine;
import racingcar.engine.FixedGoPowerEngine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private static CarName carName = CarName.newInstance("car1");

    @DisplayName("자동차 생성")
    @Test
    void newCar() {
        //when
        Car car = Car.newInstance(carName, new FixedGoPowerEngine());

        //then
        assertThat(car).isNotNull();
    }

    @DisplayName("현재위치 확인")
    @Test
    void getPosition() {
        Car car = Car.newInstance(carName, new FixedGoPowerEngine());

        //then
        int expected = 0;
        assertEquals(0, car.getPosition());
    }

    @DisplayName("power가 4 이상이면 전진")
    @Test
    void move() {
        //given
        Car car = Car.newInstance(carName, new FixedGoPowerEngine());
        int before = car.getPosition();

        //when
        car.move();

        //then
        assertEquals(before + 1, car.getPosition());
    }

    @DisplayName("power가 4 미만이면 정지")
    @Test
    void stop() {
        //given
        Car car = Car.newInstance(carName, new FixedStopPowerEngine());
        int before = car.getPosition();

        //when
        car.move();

        //then
        assertEquals(before, car.getPosition());
    }
}
