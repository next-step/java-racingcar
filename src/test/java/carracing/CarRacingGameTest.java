package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    private final Car car = new Car();

    @DisplayName("자동차 전진 동작 테스트")
    @Test
    void car_move_once() {
        assertThat(car.canMove()).isTrue();
    }
}
