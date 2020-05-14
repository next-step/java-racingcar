package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("move 메서드를 실행하면 car의 position이 1 증가한다")
    void move() throws NoSuchFieldException, IllegalAccessException {
        //given
        Car car = new Car();
        Field field = car.getClass().getDeclaredField("position");
        field.setAccessible(true);

        //when
        car.move();

        //then
        assertThat(field.get(car)).isEqualTo(1);
    }
}