package step4;

import org.junit.jupiter.api.Test;
import step3.domain.RacingCar;
import step3.strategy.ForwardStrategy;
import step3.strategy.HoldStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    void 전진() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(new ForwardStrategy());
        assertThat(racingCar.position() > 0).isTrue();
    }

    @Test
    void 멈춤() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(new HoldStrategy());
        assertThat(racingCar.position() == 0).isTrue();
    }

}
