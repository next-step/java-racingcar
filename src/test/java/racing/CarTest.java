package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차는 한 칸 씩 움직여야 한다.")
    void moveOneSpace() {
        int location = car.getLocation();

        car.move();

        assertThat(car.getLocation()).isEqualTo(location + 1);
    }

}
