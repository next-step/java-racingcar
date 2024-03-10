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

    @Test
    void 우승자_한_명_테스트() {
        // given
        final RacingCar pobi = new RacingCar(new Location(1), new Name("pobi"));
        final RacingCar crong = new RacingCar(new Location(4), new Name("crong"));
        final RacingCar honux = new RacingCar(new Location(2), new Name("honux"));
        final RacingCars racingCars = new RacingCars(List.of(pobi, crong, honux));

        // when
        final Winners winners = racingCars.findWinners();

        // then
        assertThat(winners.getNames()).containsExactly(new Name("crong"));
    }

    @Test
    void 우승자_두_명_테스트() {
        final RacingCar pobi = new RacingCar(new Location(1), new Name("pobi"));
        final RacingCar crong = new RacingCar(new Location(4), new Name("crong"));
        final RacingCar honux = new RacingCar(new Location(4), new Name("honux"));
        final RacingCars racingCars = new RacingCars(List.of(pobi, crong, honux));

        // when
        final Winners winners = racingCars.findWinners();

        // then
        assertThat(winners.getNames()).containsExactly(new Name("crong"), new Name("honux"));
    }
}
