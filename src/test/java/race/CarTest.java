package race;

import org.junit.jupiter.api.Test;
import race.model.Car;
import race.strategy.AlwaysMoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void generateCar() {
        Car car = new Car();
        assertEquals(car.position, 0);

        car.move(true);
        assertEquals(car.position, 1);
    }

    @Test
    void alwaysMoveStrategy() {
        Car car = new Car();
        car.move(new AlwaysMoveStrategy().isMovable());
        car.move(new AlwaysMoveStrategy().isMovable());

        assertEquals(car.position, 2);
    }
}
