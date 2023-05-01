package RacingCarGame.entity.car;

import RacingCarGame.entity.MovableNumberGenerator;
import RacingCarGame.entity.NonMovableNumberGenerator;
import entity.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    @DisplayName("자동차 move 이동")
    void moveCar() {

        Car moveCar = new Car("move");
        Car notMoveCar = new Car("non");

        moveCar.move(new MovableNumberGenerator());
        notMoveCar.move(new NonMovableNumberGenerator());

        assertThat(moveCar.getPositionValue()).isEqualTo(1);
        assertThat(notMoveCar.getPositionValue()).isEqualTo(0);
    }
}