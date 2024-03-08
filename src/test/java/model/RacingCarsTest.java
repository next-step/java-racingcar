package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        final int racingCarNumber = 3;

        // when
        final RacingCars racingCars = RacingCars.of(racingCarNumber);

        // then
        assertThat(racingCars.getCarNumber()).isEqualTo(3);
    }
}
