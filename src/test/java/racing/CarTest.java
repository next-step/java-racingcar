package racing;

import org.junit.jupiter.api.Test;
import racing.entity.Car;
import racing.entity.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void carMoves() {
        Car car = new Car("Car");
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    void carDoesNotMove() {
        Car car = new Car("Car") {
            @Override
            public void move() {
                if (canMove(5)) {
                    Position position = new Position(1);
                }
            }

        };
        car.move();
        assertEquals(0, car.getPosition());
    }

    @Test
    void carNameIsSetCorrectly() {
        Car car = new Car("Car");
        assertEquals("Car", car.getName());
    }

    @Test
    void carInitialPositionIsZero() {
        Car car = new Car("Car");
        assertEquals(0, car.getPosition());
    }
}