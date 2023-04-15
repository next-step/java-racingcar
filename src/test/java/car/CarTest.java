package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 이동할 수 있는 경우 위치가 1 증가한다")
    @Test
    void move() {
        Car car = new Car();
        int position = car.getPosition();

        MoveStrategy moveStrategy = () -> true;
        car.move(moveStrategy);
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

    @DisplayName("자동차가 이동할 수 없는 경우 위치가 증가하지 않는다")
    @Test
    void notMove() {
        Car car = new Car();
        int position = car.getPosition();

        MoveStrategy moveStrategy = () -> false;
        car.move(moveStrategy);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}
