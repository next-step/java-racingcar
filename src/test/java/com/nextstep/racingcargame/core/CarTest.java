package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private static final String TEST_CAR_NAME = "test";
    private static final String INVALID_CAR_NAME = "too much long name";

    @ParameterizedTest(name = "[{index}] randomNumber 가 {0} 일 경우 차량이 {1}칸 앞으로 움직인다 ")
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void carMoveForwardTest(int valueSource, int expectedDistance) {
        Car car = new Car(TEST_CAR_NAME);
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveForwardByNumber(valueSource);
        assertThat(car.getDistance()).isEqualTo(expectedDistance);
    }

    @ParameterizedTest(name = "[{index}] randomNumber 가 {0} 일 경우 차량은 한턴 정지한다")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0"}, delimiter = ':')
    void carStopTest(int valueSource, int expectedDistance) {
        Car car = new Car(TEST_CAR_NAME);
        assertThat(car.getDistance()).isEqualTo(0);
        car.moveForwardByNumber(valueSource);
        assertThat(car.getDistance()).isEqualTo(expectedDistance);
    }

    @Test
    @DisplayName("자동차 이름이 5글자 이상인 경우 객체 생성시 예외를 발생시킨다")
    void carCreateFailTest() {
        assertThatThrownBy(() -> new Car(INVALID_CAR_NAME))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}