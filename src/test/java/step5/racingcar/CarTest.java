package step5.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.racingcar.domain.Car;
import step5.racingcar.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("car 객체 생성 및 기본값 테스트")
    @Test
    public void makeNewCarObject() {
        Car car = new Car("abc", new RandomMovingStrategy());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("car 객체가 움직이는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 4, 1})
    public void checkWhetherCarObjectMoves(int distance) {
        Car movingCar = new Car("movingCar", () -> true);
        Car stoppingCar = new Car("stoppingCar", () -> false);
        for (int i = 0; i < distance; i++) {
            movingCar.move();
            stoppingCar.move();
        }
        assertThat(movingCar.getPosition()).isEqualTo(distance);
        assertThat(stoppingCar.getPosition()).isEqualTo(0);
    }
}
