package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("처음 위치는 0이다")
    void initialPositionIsZero() {
        Car car = new Car(() -> true);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
