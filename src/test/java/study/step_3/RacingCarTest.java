package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("0에서 9 사이의 랜덤 값을 생성한다")
    void shouldGenerateRandomNumberBetweenZeroAndNine() {
        RandomNumber randomNumber = new RandomNumber();

        assertThat(randomNumber.generate()).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 값이 4 이상인 경우 횟수를 센다")
    void shouldCountIfGreaterThanFour(int randomNumber) {
        Car car = new Car();

        if (car.canMove(randomNumber)) {
            car.move();
        }

        assertThat(car.getNumberOfMoves()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 값이 4 미만인 경우 횟수를 세지 않는다")
    void shouldNotCountIfLessThanFour(int randomNumber) {
        Car car = new Car();

        if (car.canMove(randomNumber)) {
            car.move();
        }

        assertThat(car.getNumberOfMoves()).isEqualTo(0);
    }
}
