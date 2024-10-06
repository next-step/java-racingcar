package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 차_생성시_위치는_0이다() {
        Car car = new Car("a");

        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_차가_전진한다() {
        Car car = new Car("a");

        car.move(4);

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 숫자가_4미만이면_차가_멈춘다() {
        Car car = new Car("a");

        car.move(3);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 숫자가_음수면_차가_멈춘다() {
        Car car = new Car("a");

        car.move(-3);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    void 차_생성_빈값() {
        assertThatThrownBy(() ->
               new Car("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
