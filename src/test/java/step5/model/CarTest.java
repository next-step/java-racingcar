package step5.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void car() {
        Car car = new Car("kim", new RandomMoveStrategy());
    }

    @Test
    void move() {
        Car car = new Car("kim", new MoveStrategy() {
            @Override
            public Position move(Position position) {
                return position.increase();
            }
        });
        car.move();

        assertThat(car).isEqualTo(new Car("kim", 1, new RandomMoveStrategy()));
    }

    @Test
    void isWinner() {
        Car car = new Car("kim", 3, new RandomMoveStrategy());
        assertAll(
            () -> assertTrue(car.isWinner(new Position(3))),
            () -> assertFalse(car.isWinner(new Position(2)))
        );
    }
}
