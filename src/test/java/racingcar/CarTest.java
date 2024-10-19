package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarPosition;
import racingcar.domain.MovingStrategy;


import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차가 항상 이동하는지 확인")
    @ValueSource(strings = {"yun"})
    void alwaysMove(String name) {
        Car car = new Car(new CarName(name), new CarPosition(0));
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 멈춰있는지 확인")
    @ValueSource(strings = {"yun"})
    void neverMove(String name) {
        Car car = new Car(new CarName(name), new CarPosition(0));
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

}
