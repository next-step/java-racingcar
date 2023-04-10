package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    MoveStrategy nonMove = new NonMove();
    MoveStrategy move = new Move();

    @Test
    void move() {
        Car car = new Car();
        car.move(move);
        assertThat(car.getMove()).isEqualTo(2);
    }

    @Test
    void nonMove() {
        Car car = new Car();
        car.move(nonMove);
        assertThat(car.getMove()).isEqualTo(1);
    }

}