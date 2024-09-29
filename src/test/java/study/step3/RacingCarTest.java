package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.car.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void random값이_4미만인_경우() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(3);

        assertThat(racingCar.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void random값이_4이상인_경우() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(4);

        assertThat(racingCar.getCurrentPosition()).isEqualTo(2);
    }
}
