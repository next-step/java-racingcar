package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class RacingCarTest {
    RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void 전진조건_테스트() {
        assertThat(RacingCar.random()).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    void 이동_또는_정지_테스트() {
        assertThat(racingCar.moveOrStop()).isGreaterThanOrEqualTo(0);
    }
}
