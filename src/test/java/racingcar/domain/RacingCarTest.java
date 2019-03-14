package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    public void 생성() {
        // given
        // when
        final RacingCar racingCar = new RacingCar(1);

        // then
        assertThat(racingCar).isNotNull();
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동하는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(1);

        // when
        racingCar.move(() -> true);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하지_않는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(1);

        // when
        racingCar.move(() -> false);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}
