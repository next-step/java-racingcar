package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Location;
import racingcar.domain.Owner;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("전진 테스트")
    @Test
    void move_test() {
        RacingCar racingCar = new RacingCar(new Owner("pobi"), new Location(0));
        racingCar.move(3);
        assertThat(0).isEqualTo(racingCar.getLocation());

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar(new Owner("crong"), new Location(0));
        racingCar.move(3);
        assertThat(0).isEqualTo(racingCar.getLocation());

    }
}
