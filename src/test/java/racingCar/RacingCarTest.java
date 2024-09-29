package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("한 칸 이동할 경우 position이 1 증가한다.")
    public void moveForward_positionShouldBeIncrease() {
        int prevPosition = racingCar.getPosition();
        racingCar.moveForward();

        assertThat(racingCar.getPosition()).isEqualTo(prevPosition + 1);
    }

}