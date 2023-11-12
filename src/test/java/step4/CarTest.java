package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.Car;
import step4.model.ForwardMoveStrategy;
import step4.model.StopMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("4 이상의 숫자를 받는다면 앞으로 전진한다.")
    void carGoTest() {
        Car car = new Car("tester1", 0);
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        car.go(new ForwardMoveStrategy().isMovable());
        assertThat(car.getCurrentStatus()).isEqualTo(1);
    }

    @Test
    @DisplayName("4보다 작은 숫자를 받는다면 앞으로 전진하지 않는다.")
    void carDoNotGoTest() {
        Car car = new Car("tester1", 0);
        assertThat(car.getCurrentStatus()).isEqualTo(0);

        car.go(new StopMoveStrategy().isMovable());
        assertThat(car.getCurrentStatus()).isEqualTo(0);
    }
}
