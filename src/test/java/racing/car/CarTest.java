package racing.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car(() -> 1);
    }

    @Test
    @DisplayName("자동차는 한 칸 씩 움직여야 한다.")
    void moveOneSpace() {
        int firstLocation = car.getLocation();
        int round = 5;

        for (int i = 0; i < round; i++) {
            car.move();
        }


        assertThat(car.getLocation()).isEqualTo(firstLocation + round);
    }

}
