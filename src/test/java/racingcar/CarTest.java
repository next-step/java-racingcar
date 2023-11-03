package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(new RandomMovingStrategy());
    }

    @Test
    @DisplayName("생성된 자동차는 모두 0이라는 출발 포지션을 가진다.")
    void createNewCar() {
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("Moving 전략에 따라 반환되는 숫자만큼 자동차를 이동시킨다.")
    void randomMove() {
        new Car(() -> 1);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
