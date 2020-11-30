package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import race.model.Car;
import race.strategytest.AlwaysMoveStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    public Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new AlwaysMoveStrategy());
        car.move();
        car.move();
        car.move();
    }

    @Test
    void alwaysMoveStrategy() {
        assertEquals(car.history.get(0), true);
        assertEquals(car.history.get(1), true);
        assertEquals(car.history.get(2), true);
        assertEquals(car.history.size(), 3);
    }

    @Test
    void getPosition() {
        assertEquals(car.getPositionInRace(3), 3);
    }
}
