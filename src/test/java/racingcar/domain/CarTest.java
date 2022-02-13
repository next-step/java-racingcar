package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> Car.validateCarName("oneeee"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 난수가_4_미만일_떄_자동차는_전진하지_않는다() {
        Car car = new Car("race");
        car.moveCarRandomly(() -> false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 난수가_4_이상일_떄_자동차는_전진힌다() {
        Car car = new Car("race");
        car.moveCarRandomly(() -> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
