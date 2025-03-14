package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    private final Car car = new Car();

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 미만")
    @Test
    void car_move_below_4() {
        assertThat(car.move(3)).isEqualTo(0);
    }

    @DisplayName("자동차 한 번 전진 동작 테스트 - 4 이상")
    @Test
    void car_move_over_4() {
        assertThat(car.move(4)).isEqualTo(1);
    }
}
