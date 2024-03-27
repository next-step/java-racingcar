package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static step4.common.Constant.NATURAL_FIRST;

@DisplayName("RacingCar 테스트")
public class RacingCarTest {

    @DisplayName("전진 테스트")
    @Test
    void 전진() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> true);
        assertThat(racingCar.position() > NATURAL_FIRST).isTrue();
    }

    @DisplayName("멈춤 테스트")
    @Test
    void 멈춤() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> false);
        assertThat(racingCar.position() == NATURAL_FIRST).isTrue();
    }

}
