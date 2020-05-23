package com.kimdahyeee.racing;

import com.kimdahyeee.racing.rule.Movable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 경주 단위 테스트")
class CarTest {

    @Test
    @DisplayName("자동차가 전진하는 룰에 충족되지 않는다면 전진하지 않는다.")
    void stop() {
        Movable movable = () -> false;

        Car car = new Car("car", movable);
        car.move();

        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 전진하는 룰에 충족된다면 전진한다.")
    void move() {
        Movable movable = () -> true;
        Car car = new Car("car", movable);
        car.move();

        assertEquals(1, car.getPosition());
    }

}