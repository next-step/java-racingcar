package com.racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    void move(int input, int expected) {
        //when
        car.move(input);

        //then
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}
