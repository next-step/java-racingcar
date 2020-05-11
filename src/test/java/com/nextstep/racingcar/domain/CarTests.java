package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("4 이상의 값을 입력받은 차량은 움직이고 움직인 거리가 1증가한다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    void moveCarTest(int value) {
        assertThat(newCar.getMoveLength()).isEqualTo(0);
        newCar.move(value);
        assertThat(newCar.getMoveLength()).isEqualTo(1);
    }

    @DisplayName("4 미만의 값을 입력받은 차량은 움직이지 않고 움직인 거리가 변하지 않는다..")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void moveCarFailTest(int value) {
        assertThat(newCar.getMoveLength()).isEqualTo(0);
        newCar.move(value);
        assertThat(newCar.getMoveLength()).isEqualTo(0);
    }
}
