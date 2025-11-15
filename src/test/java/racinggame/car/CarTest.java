package racinggame.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 주사위값이_4이상이면_자동차위치를_전진시킬_수_있다() {
        Car car = new Car("mins");

        car.move(4);

        assertThat(
                car.isSamePosition(1)
        ).isTrue();
    }

    @Test
    void 주사위값이_4미만이면_자동차위치를_전진시킬_수_없다() {
        Car car = new Car("mins");

        car.move(3);

        assertThat(
                car.isSamePosition(1)
        ).isFalse();
    }

    @Test
    void 주어진_위치값_보다_자동차_위치값이_더_작은걸_판별할_수_있다() {
        Car car = new Car("mins");

        car.updatePosition(2);

        assertThat(
                car.hasDownPosition(3)
        ).isTrue();
    }
}