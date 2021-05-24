package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void mustStop() {
        Car car = new Car("pobi");
        car.run(false);
        Assertions.assertThat(car.getLocation()).isEqualTo(0);
    }
    @Test
    void mustMove() {
        Car car = new Car("pobi");
        car.run(true);
        Assertions.assertThat(car.getLocation()).isEqualTo(1);
    }
}