package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.move.MoveStrategy;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4이상일 경우(RandomMoveStrategy) 전진")
    @Test
    void moveTest() {
        MoveStrategy moveStrategy = () -> true;
        Car car = new Car("car1", moveStrategy);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4미만일 경우 정지")
    @Test
    void stopTest() {
        MoveStrategy moveStrategy = () -> false;
        Car car = new Car("car1", moveStrategy);
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
