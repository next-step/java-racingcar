package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    MoveStrategy nonMove = new NonMove();
    MoveStrategy moveOneSpace = new MoveOneSpace();

    @Test
    void move() {
        Car car = new Car();
        car.move(moveOneSpace);
        assertThat(car.getCarDTO()
            .getPosition())
            .isEqualTo(1);
    }

    @Test
    void nonMove() {
        Car car = new Car();
        car.move(nonMove);
        assertThat(car.getCarDTO()
            .getPosition())
            .isEqualTo(0);
    }

}