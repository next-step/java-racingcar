package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final String TEST_NAME = "jason";
    private static final int TEST_POSITION = 0;

    @Test
    public void 생성() {
        // given
        // when
        final RacingCar racingCar = new RacingCar(TEST_NAME, TEST_POSITION);

        // then
        assertThat(racingCar).isNotNull();
        assertThat(racingCar.getName()).isEqualTo(TEST_NAME);
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동하는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(TEST_NAME, TEST_POSITION);

        // when
        final RacingCar racingCarAfterMoving = racingCar.move(() -> true);

        // then
        assertThat(racingCarAfterMoving.getPosition()).isEqualTo(1);
    }

    @Test
    public void 이동하지_않는_경우() {
        // given
        final RacingCar racingCar = new RacingCar(TEST_NAME, TEST_POSITION);

        // when
        final RacingCar racingCarAfterMoving = racingCar.move(() -> false);

        // then
        assertThat(racingCarAfterMoving.getPosition()).isEqualTo(0);
    }

    @Test
    public void 같은_위치_확인() {
        // given
        final RacingCar racingCar = new RacingCar(TEST_NAME, TEST_POSITION);

        // when
        final boolean inPosition = racingCar.isInPosition(TEST_POSITION);

        // then
        assertThat(inPosition).isTrue();
    }
}
