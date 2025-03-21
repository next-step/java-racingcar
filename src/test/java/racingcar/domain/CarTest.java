package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 움직임 전략에 따라 움직여야 한다")
    void move() {
        Car car1 = Car.of("pobi");
        car1.move(() -> true);
        Assertions.assertThat(car1.getPosition()).isEqualTo(Position.of(1));

        Car car2 = Car.of("crong");
        car2.move(() -> false);
        Assertions.assertThat(car2.getPosition()).isEqualTo(Position.of(0));
    }
}
