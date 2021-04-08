package racingcar.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void racingCarRandomMoveTest() {
        RacingCar racingCar = new RacingCar();
        racingCar.move(() -> true);

        assertThat(racingCar.getMoveCnt()).isEqualTo(1);
    }
}