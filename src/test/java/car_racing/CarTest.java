package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("when create car, default status are set - position equals to 0")
    void createCar() {
        // given
        // when
        Car car = new Car();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Move car with test strategy - position becomes plus 1")
    void moveCar() {
        // given
        Car car = new Car();
        MoveStrategy moveStrategy = new TestMoveStrategy();

        // when
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
