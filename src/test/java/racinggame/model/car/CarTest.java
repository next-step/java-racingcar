package racinggame.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racinggame.model.position.Position;
import racinggame.move.AlwaysMoveStrategy;

class CarTest {

    @Test
    void 전진조건을_만족하면_자동차_위치값을_증가시킬_수_있다() {
        Car car = new Car("mins");

        car.move(new AlwaysMoveStrategy());

        assertThat(
                car.isSamePosition(new Position(1))
        ).isTrue();
    }

    @Test
    void 주어진_위치값_보다_자동차_위치값이_더_작은걸_판별할_수_있다() {
        Car car = new Car("mins");

        car.move(new AlwaysMoveStrategy());

        assertThat(
                car.hasDownPosition(new Position(2))
        ).isTrue();
    }
}