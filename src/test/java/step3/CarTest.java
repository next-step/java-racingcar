package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("움직임 여부를 받아 움직이면, 움직인 거리가 +1 된다. 움직이지 않은 경우는 움직인 거리는 그대로 유지된다.")
    void move() {
        car.move(true);
        assertThat(car.getDistance()).isEqualTo(1);

        car.move(false);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
