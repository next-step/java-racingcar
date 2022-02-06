package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> Car.validateCarName("oneeee"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 난수가_5일때_자동차는_전진한다() {
        Car car = new Car("race");
        car.moveCarRandomly(5);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 난수가_4일때_자동차는_전진한다() {
        Car car = new Car("race");
        car.moveCarRandomly(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 난수가_3일때_자동차는_전진하지_않는다() {
        Car car = new Car("race");
        car.moveCarRandomly(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
