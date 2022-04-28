package study.step5.try3.domain;

import org.junit.jupiter.api.Test;
import study.step5.try3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름_확인하기() {
        assertThat(Car.of("pobi", 0).getCarName()).isEqualTo("pobi");
    }

    @Test
    void 자동차가_전진하는_경우() {
        Car car = Car.of("pobi", 0);
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차가_멈추는_경우() {
        Car car = Car.of("pobi", 0);
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
