package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.LoadMovable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @DisplayName("처음 자동차를 생성하면, 거리는 1이다.")
    @Test
    void 자동차_생성() {
        assertThat(new Car(1, new LoadMovable(), new CarName("init")).getDistance()).isEqualTo(1);
    }

    @DisplayName("4이상이면 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8})
    void 전진(int input) {
        Car car = new Car(1, new LoadMovable(), new CarName("car1"));
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("4 미만이면 멈춤")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 멈춤(int input) {
        Car car = new Car(1, new LoadMovable(), new CarName("car1"));
        car.move(input);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
