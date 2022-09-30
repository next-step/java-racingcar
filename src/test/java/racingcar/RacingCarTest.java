package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("한 칸 이동 테스트")
    @Test
    void moveRacingCar() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> true);
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }

    @DisplayName("제자리 테스트")
    @Test
    void stayRacingCar() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> false);
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }
}
