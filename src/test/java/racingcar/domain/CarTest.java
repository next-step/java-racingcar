package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final static String NAME_OF_CAR = "TEST";

    @DisplayName("자동차 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveCarTest(int power) {

        Car car = new Car(makeEngine(power), NAME_OF_CAR);
        car.moveAndStop();
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("자동차 정지")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void stopCarTest(int power) {

        Car car = new Car(makeEngine(power), NAME_OF_CAR);
        car.moveAndStop();
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @DisplayName("자동차 이름 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    public void carNameTest(String name) {

        Car car = new Car(makeEngine(3), name);
        assertThat(car.getName()).isEqualTo(name);
    }

    private Engine makeEngine(int power) {
        return new Engine(() -> power);
    }
}
