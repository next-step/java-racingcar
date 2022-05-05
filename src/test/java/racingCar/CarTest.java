package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 이동() {
        Car car = new Car(3);
        car.move(4);
        assertThat(car.isSamePosition(new Position(4))).isTrue();
    }

    @Test
    void 정지() {
        Car car = new Car(3);
        car.move(3);
        assertThat(car.isSamePosition(new Position(3))).isTrue();
    }

    @Test
    void 이동범위예외처리() {
        assertThatThrownBy(() -> {
            Car car = new Car();
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동범위확인() {
        assertThatThrownBy(() -> {
            Car car = new Car();
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
