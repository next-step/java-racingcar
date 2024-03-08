package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 랜덤_값이_4이상이면_전진한다() {
        // given
        final int randomNumber = 4;
        final RacingCar racingCar = new RacingCar();

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(1);
    }
}
