package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final int TEST_ID = 1;
    private static final String TEST_NAME = "jason";

    @Test
    public void 생성() {
        // given
        // when
        final RacingCar racingCar = new RacingCar(TEST_ID, TEST_NAME);

        // then
        assertThat(racingCar).isNotNull();
        assertThat(racingCar.getName()).isEqualTo(TEST_NAME);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동하는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(TEST_ID, TEST_NAME);

        // when
        racingCar.move(() -> true);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하지_않는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(TEST_ID, TEST_NAME);

        // when
        racingCar.move(() -> false);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }
}
