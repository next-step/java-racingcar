package racingcar.step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step5.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("값 찍어서 테스트 - 4이상 9이하면 움직인다")
    void carMove() {
        Car car = new Car("k3", 1);
        car.move(4);
        car.move(9);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("값 찍어서 테스트 - 4이상 9이하가 아니면 멈춘다")
    void carStop() {
        Car car = new Car("k3", 1);
        car.move(3);
        car.move(10);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값 테스트 - 4이상이면 움직인다")
    void carMoveRandom() {
        Car car = new Car("k3", 1);
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
