package racing.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing.domain.move.MoveOneSpace;
import racing.domain.move.MoveStrategy;
import racing.domain.move.NonMove;

class CarTest {

    MoveStrategy nonMove = new NonMove();
    MoveStrategy moveOneSpace = new MoveOneSpace();

    @Test
    void move() {
        Car car = new Car("daeuk");
        car.move(moveOneSpace);
        assertThat(car.getCarDTO()
            .getPosition())
            .isEqualTo(1);
    }

    @Test
    void nonMove() {
        Car car = new Car("daeuk");
        car.move(nonMove);
        assertThat(car.getCarDTO()
            .getPosition())
            .isEqualTo(0);
    }

}