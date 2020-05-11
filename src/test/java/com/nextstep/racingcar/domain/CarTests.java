package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTests {
    private Car newCar;

    @BeforeEach
    public void setup() {
        newCar = new Car();
    }

    @DisplayName("처음 만들어진 차량은 움직인 거리가 0이다.")
    @Test
    void newCarTest() {
        assertThat(newCar.getMoveLength()).isEqualTo(0);
    }

    @DisplayName("움직인 차량은 거리가 1씩 증가한다")
    @Test
    void moveCarTest() {
        newCar.move();
        assertThat(newCar.getMoveLength()).isEqualTo(1);
    }
}
