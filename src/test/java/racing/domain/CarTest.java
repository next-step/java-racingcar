package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 전진")
    void testCarMove() {
        // given
        Car car = new Car("monds");
        // when
        car.move();
        // then
        assertThat(car.getMovedDistance()).isEqualTo(1);
    }
}
