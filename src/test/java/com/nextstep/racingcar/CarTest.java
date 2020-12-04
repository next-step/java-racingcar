package com.nextstep.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int CAR_COUNT = 5;
    private Car car;

    @BeforeEach
    public void init(){
        car = new Car(CAR_COUNT);
    }

    @DisplayName("move 호출 시 position이 1씩 증가하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void move(int count) {
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(count);
    }

    @DisplayName("현재 position에 따른 finished 체크")
    @ParameterizedTest
    @CsvSource({"3, true", "4, true", "5, false"})
    public void isFinished(int count, boolean expected) {
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            car.move();
        }
        assertThat(car.isNotFinished()).isEqualTo(expected);
    }
}
