package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("전진 테스트")
    @Test
    void move_test() {
        RacingCar racingCar = new RacingCar("pobi", 0);
        racingCar.move(4);
        assertThat(racingCar.checkFromLocation(1)).isTrue();

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar("pobi", 0);
        racingCar.move(3);
        assertThat(racingCar.checkFromLocation(0)).isTrue();

    }
}
