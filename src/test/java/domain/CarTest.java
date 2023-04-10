package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(3);
    }

    @Test
    void move() {
        car.move(2);
        assertEquals(new Car(5).getLocation(), car.getLocation());
    }

    @Test
    void getLocation() {
        assertEquals(new Car(3).getLocation(), car.getLocation());
    }
}
