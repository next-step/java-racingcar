package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.logic.CarEngine;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    @DisplayName("우승자를 정상적으로 선출하는지 확인한다")
    void checkWinnerIsProperlySelected() {
        // given
        CarEngine carEngine = new MockCarEngine(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", carEngine).tryMove().tryMove(),
                RacingCar.of("red", carEngine).tryMove(),
                RacingCar.of("yellow", carEngine).tryMove().tryMove().tryMove()));
        // when
        List<String> winners = racingCars.getWinners();
        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("yellow");
    }

    @Test
    @DisplayName("우승자가 두명인경우 정상적으로 선출하는지 확인한다")
    void checkTwoWinnersAreProperlySelected() {
        // given
        CarEngine carEngine = new MockCarEngine(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", carEngine).tryMove().tryMove().tryMove(),
                RacingCar.of("red", carEngine).tryMove(),
                RacingCar.of("yellow", carEngine).tryMove().tryMove().tryMove()));
        // when
        List<String> winners = racingCars.getWinners();
        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("blue");
        assertThat(winners.get(1)).isEqualTo("yellow");
    }

    @Test
    @DisplayName("모두 우승한경우 정상적으로 선출하는지 확인한다")
    void checkWinAll() {
        // given
        CarEngine carEngine = new MockCarEngine(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", carEngine).tryMove().tryMove().tryMove(),
                RacingCar.of("red", carEngine).tryMove().tryMove().tryMove(),
                RacingCar.of("yellow", carEngine).tryMove().tryMove().tryMove()));
        // when
        List<String> winners = racingCars.getWinners();
        // then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.get(0)).isEqualTo("blue");
        assertThat(winners.get(1)).isEqualTo("red");
        assertThat(winners.get(2)).isEqualTo("yellow");
    }
}
