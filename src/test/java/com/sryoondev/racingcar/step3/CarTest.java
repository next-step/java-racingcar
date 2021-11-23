package com.sryoondev.racingcar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {
    @ParameterizedTest
    @DisplayName("입력 값에 따라 전진하거나 멈추는지 테스트")
    @CsvSource(value = {"true,1", "false,0"})
    void testRace(boolean movable, int moveDistance) {
        Car car = new Car("pobi");
        car.race(movable);
        assertThat(car.getMoveDistance()).isEqualTo(moveDistance);
    }

    @Test
    @DisplayName("이름을 부여하는 차 객체 생성 테스트")
    void testCarName() {
        Car car = new Car("pobi");
        assertThat(car);
    }

    @Test
    @DisplayName("이름을 5자 이상 초과했을 때 테스트")
    void testValidCarName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("hailey"))
                .withMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
