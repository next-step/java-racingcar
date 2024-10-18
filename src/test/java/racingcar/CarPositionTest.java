package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    @DisplayName("자동차의 초기 위치가 올바르게 설정되는지 확인")
    void carInitPosition() {
        CarPosition carPosition = new CarPosition(0);
        assertThat(carPosition.getCurrentPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 전진할 때 위치가 1 증가하는지 확인")
    void carMovesPosition() {
        CarPosition carPosition = new CarPosition(0);
        carPosition.move();
        assertThat(carPosition.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 여러 번 전진할 때 위치가 올바르게 증가하는지 확인")
    void carMovesPositionMultipleTimes() {
        CarPosition carPosition = new CarPosition(0);
        carPosition.move();
        carPosition.move();
        assertThat(carPosition.getCurrentPosition()).isEqualTo(2);
    }
}