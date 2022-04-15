package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("생성된 자동차 객체의 초기 위치 확인")
    void checkInitialPositionCreatedCarObject() {
        Car car = new Car();

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("자동차가 움직인 후의 위치 변화 확인")
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    void checkPositionMovedCar(int input, int expected) {
        Car car = new Car();
        car.move(input);
        assertThat(car.currentPosition()).isEqualTo(expected);
    }
}