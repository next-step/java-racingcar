package step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("레이싱 카 객체 생성")
    void createRacingCar() {
        assertThat(new RacingCar(1)).isInstanceOf(RacingCar.class);
    }

    @Test
    @DisplayName("정지 혹은 전진")
    void stopOrForward() {
        RacingCar racingCar = new RacingCar(1);
        assertThat(racingCar.stopOrForward(0)).isIn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    @DisplayName("레이싱 카 객체 생성 시, 음수 예외 처리")
    void racingCarThrowNegativeArg() {
        assertThatThrownBy(() -> new RacingCar(-1)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
