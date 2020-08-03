package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final static String NAME_OF_CAR = "TEST";

    @DisplayName("자동차 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveCar(final int fuel) {

        Car car = new Car(NAME_OF_CAR);
        car.moveAndStop(() -> fuel);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("자동차 정지")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void stopCar(final int fuel) {

        Car car = new Car(NAME_OF_CAR);
        car.moveAndStop(() -> fuel);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}
