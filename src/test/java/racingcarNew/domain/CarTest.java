package racingcarNew.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차가_이동하는지_확인() {
        Car car = new Car("pobi");
        car.move(5);
        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차가_이동하지_않는지_확인() {
        Car car = new Car("pobi");
        car.move(2);
        assertThat(0).isEqualTo(car.getPosition());
    }

}