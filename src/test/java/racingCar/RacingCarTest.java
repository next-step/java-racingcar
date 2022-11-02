package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void 자동차_서로_비교() {
        RacingCar car_position0 = new RacingCar("test", 0);
        RacingCar car_position3 = new RacingCar("test", 3);

        assertThat(car_position0.compareTo(car_position3)).isEqualTo(-3);
        assertThat(car_position0.compareTo(car_position0)).isEqualTo(0);
        assertThat(car_position3.compareTo(car_position0)).isEqualTo(3);
    }
}