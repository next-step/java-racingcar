package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("random 값 >= 4일 경우 전진할 수 있다")
    void go_forward_test() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition() > 1);
    }
}
