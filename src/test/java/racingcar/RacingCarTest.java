package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("4이상일 경우 전진, 아니면 멈춤")
    public void goStop()
    {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.drive(1)).isEqualTo(0);
        assertThat(racingCar.drive(4)).isEqualTo(1);
    }
}
