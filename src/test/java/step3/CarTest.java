package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void carMoveTest() {
        Car car = new Car(0);

        car.move(0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(2);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
