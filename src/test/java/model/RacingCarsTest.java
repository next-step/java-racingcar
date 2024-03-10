package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        final List<String> racingCarNames = List.of("pobi","crong", "honux");

        // when
        final RacingCars racingCars = RacingCars.of(racingCarNames);

        // then
        assertThat(racingCars.getRacingCars()).hasSize(3);
    }
}
