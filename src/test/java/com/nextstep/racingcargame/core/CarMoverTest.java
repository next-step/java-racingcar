package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarMoverTest {

    @ParameterizedTest(name = "[{index}] random 값이 {0} 일때 차량은 움직이지 않는다")
    @ValueSource(ints = {0,1,2,3,4})
    void carMoverStopTest(int valueSource) {
        Car car = new Car();
        CarMover carMover = new CarMover(valueSource);
        carMover.moveCar(car);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest(name = "[{index}] random 값이 {0} 일때 차량은 움직인다")
    @ValueSource(ints = {5,6,7,8,9})
    void carMoverForwardTest(int valueSource) {
        Car car = new Car();
        CarMover carMover = new CarMover(valueSource);
        carMover.moveCar(car);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}