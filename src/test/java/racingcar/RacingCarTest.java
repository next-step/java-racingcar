package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("초기화가 정상적으로 이뤄지는지 확인한다.")
    void initRacing(int cntCar) {
        Car[] cars = racingCar.initRacing(cntCar);
        assertThat(cars.length).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("랜덤으로 나온 결과가 4이상인 경우 전진하는지 확인한다.")
    void updateByOver4() {
        boolean randomOver4 = racingCar.isRandomOver4();

        Car car = new Car(0);
        if (randomOver4) {
            //racingCar.updateByRandom(car);
        }
    }
}