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

    @DisplayName("움직인 차량은 거리가 1씩 증가한다")
    @Test
    void moveCarTest() {
        newCar.move(4);
        assertThat(newCar.getMoveLength()).isEqualTo(1);
    }

    @DisplayName("차량의 이동 가능여부를 판단한다. 입력값이 4 이상일 때만 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6 })
    void moveableTest(int value) {
        assertThat(newCar.isMoveable(value)).isTrue();
    }
}
