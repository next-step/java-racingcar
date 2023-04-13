package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private MoveStrategy moveStrategyTrue = () -> true;
    private MoveStrategy moveStrategyFalse = () -> false;

    @Test
    @DisplayName("이동 시 위치가 1 증가한다.")
    void move() {
        Car car = new Car(moveStrategyTrue);
        car.tryMove();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 시 위치가 증가하지 않는다.")
    void stay() {
        Car car = new Car(moveStrategyFalse);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
