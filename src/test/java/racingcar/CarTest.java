package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car 이동하기")
    void moveCar() {
        Car car = new Car();
        int position = car.getPosition();

        car.move();
        int positionAfterMove = car.getPosition();

        assertThat(positionAfterMove - position).isEqualTo(1);
    }
}
