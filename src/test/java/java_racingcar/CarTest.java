package java_racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    @DisplayName("레이싱 경기를 한다")
    void carRacingTest() {
        Car moveCar = new Car();
        Car stayCar = new Car();
        moveCar.race(9);
        stayCar.race(3);

        assertAll(
                () -> assertThat(moveCar.raceResult()).isEqualTo("-"),
                () -> assertThat(stayCar.raceResult()).isBlank()
        );
    }

    @Test
    @DisplayName("0미만 randomNumber(racingNumber)를 넣으면 예외를 발생시킨다")
    void belowOneRacingNumberTest() {
        Car car = new Car();

        assertThrows(RuntimeException.class, () -> car.race(-1));
    }

    @Test
    @DisplayName("9초과의 randomNumber(racingNumber)를 넣으면 예외를 발생시킨다")
    void aboveNineRacingNumberTest() {
        Car car = new Car();

        assertThrows(RuntimeException.class, () -> car.race(10));
    }
}