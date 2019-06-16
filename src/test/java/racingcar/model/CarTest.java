package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차는 움직인다")
    void move() {
        Car car = new Car();
        int movingCount = 4;
        IntStream.range(0, movingCount).forEach(i -> car.move());
        assertThat(car.getPosition()).isEqualTo(movingCount);
    }
}
