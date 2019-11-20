package racingcarNew.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final Car car = new Car("pobi");

    @Test
    void 자동차가_이동하는지_확인() {
        car.move(true);
        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차가_이동하지_않는지_확인() {
        car.move(false);
        assertThat(0).isEqualTo(car.getPosition());
    }
}