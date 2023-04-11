import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    void moveCar() {
        Car moveCar = new Car();
        Car notMoveCar = new Car();

        moveCar.moveCar(new MovableNumberGenerator());
        notMoveCar.moveCar(new NonMovableNumberGenerator());

        assertThat(moveCar.getPositionValue()).isEqualTo(1);
        assertThat(notMoveCar.getPositionValue()).isEqualTo(0);
    }
}