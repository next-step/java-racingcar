package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("랜덤으로 나온 결과가 4이상인 경우 전진하는지 확인한다.")
    void updateByOver4() {
        boolean randomOver4 = racingGame.isRandomOver4();

        Car car = new Car(0);
        racingGame.updateByRandom(car, true);
        assertThat(car.getCountMove()).isEqualTo(1);
    }
}