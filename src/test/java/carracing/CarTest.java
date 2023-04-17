package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("값이 4이상일 경우 전진하는 테스트")
    @Test
    void move() {
        Car car = new Car();
        assertThat(car.move(5)).isEqualTo(1);
    }
}
