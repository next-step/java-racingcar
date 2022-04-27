package study.step4.try1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차를_전진시키는_경우")
    void 자동차를_전진시키는_경우() {
        Car car = new Car("pobi", 0);
        int currentPosition = car.maxPosition();
        car.move(4);
        assertThat(car.maxPosition()).isNotEqualTo(currentPosition);
    }

    @Test
    @DisplayName("자동차를_멈춤시키는_경우")
    void 자동차를_멈춤시키는_경우() {
        Car car = new Car("crong",0);
        int currentPosition = car.maxPosition();
        car.move(3);
        assertThat(car.maxPosition()).isEqualTo(currentPosition);
    }
}
