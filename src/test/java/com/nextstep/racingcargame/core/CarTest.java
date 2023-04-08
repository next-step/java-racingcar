package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest(name = "[{index}] random Number 가 {0} 일 경우 차량이 한칸 앞으로 움직인다")
    @ValueSource(ints = {5,6,7,8,9})
    void carMoveForwardTest(int valueSource) {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveForwardByNumber(valueSource);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest(name = "[{index}] random Number 가 {0} 일 경우 차량은 움직이지 않는다")
    @ValueSource(ints = {0,1,2,3,4})
    void carStopTest(int valueSource) {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveForwardByNumber(valueSource);
        assertThat(car.getDistance()).isEqualTo(0);
    }




}