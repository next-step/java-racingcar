package com.cheolhyeonpark.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("move 메서드를 실행하면 car의 position이 1 증가한다")
    void move() {
        //given
        Car car = new Car();

        //when
        car.move(true);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}