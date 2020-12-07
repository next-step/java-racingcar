package race;

import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.RandomMovePolicy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void moveTest() {
        Car car = new Car(new RandomMovePolicy());
        car.move();

        assertThat(car.getMovedDistance()).isBetween(0, 1);
    }
}
