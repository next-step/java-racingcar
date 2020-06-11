package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.mock.MockFuel;
import step4.model.Car;
import step4.model.Fuel;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;
    Fuel fuel;

    @BeforeEach
    void setUp() {
        car = Car.of("peter");
        fuel = new MockFuel();
    }

    @Test
    void create() {
        assertThat(car).isEqualTo(Car.of("peter"));
    }

    @Test
    void move() {
        car.move(fuel);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}