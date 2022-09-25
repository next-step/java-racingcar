package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void carMoveTest() {
        Car car = new Car(0);

        car.move(0);
        car.move(3);
        assertThat(car.getPositionString()).isEqualTo("-");

        car.move(4);
        assertThat(car.getPositionString()).isEqualTo("--");

        car.move(9);
        assertThat(car.getPositionString()).isEqualTo("--");
    }
}
