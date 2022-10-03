package racinggame;

import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.embeded.CarDistance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 이동() {
        Car car = new Car("car1", new CarDistance(0), () -> true);

        car.move();

        assertThat(car.getCarDistance()).isEqualTo(new CarDistance(1));
    }

    @Test
    void 정지() {
        Car car = new Car("car1", new CarDistance(0), () -> true);

        car.move();

        assertThat(car.getCarDistance()).isEqualTo(new CarDistance(1));
    }

    @Test
    void 자동차가_이름은_5글자_이상이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("12345", new CarDistance(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}