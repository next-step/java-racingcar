import entity.car.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    void moveCar() {

        Car moveCar = new Car("move");
        Car notMoveCar = new Car("non");

        moveCar.moveCar(new MovableNumberGenerator());
        notMoveCar.moveCar(new NonMovableNumberGenerator());

        assertThat(moveCar.getPositionValue()).isEqualTo(1);
        assertThat(notMoveCar.getPositionValue()).isEqualTo(0);
    }
}