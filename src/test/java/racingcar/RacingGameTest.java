package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("초기화가 정상적으로 이뤄지는지 확인한다.")
    void initRacing(int countCar) {
        List<Car> cars = racingGame.initRacing(countCar);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다")
    void carsCanGoOrStop() {
        Car car = new Car(0);

        racingGame.updateByRandom(car, 7);
        assertThat(car.getCountMove()).isEqualTo(1);

        racingGame.updateByRandom(car, 1);
        assertThat(car.getCountMove()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4이상인 경우 전진하는지 확인한다.")
    void updateByOver4(int number) {
        Car car = new Car(0);

        racingGame.updateByRandom(car, number);
        assertThat(car.getCountMove()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4미만인 경우 멈추는지 확인한다.")
    void stopByUnder4(int number) {
        Car car = new Car(0);

        racingGame.updateByRandom(car, number);
        assertThat(car.getCountMove()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤하게 나오는 값이 0에서 9사이의 숫자인지 확인한다.")
    void checkRange() {
        int randomNumber = racingGame.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThanOrEqualTo(9);
    }
}