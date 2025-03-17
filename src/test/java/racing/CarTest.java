package racing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void moveAndCurrentPosition() {
        Car car = new Car();
        assertThat(car.currentPosition()).isEqualTo(0);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(1);
        car.move();
        assertThat(car.currentPosition()).isEqualTo(2);
    }
}
