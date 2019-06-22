package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.MovingStrategy;
import racingcar.domain.moving.MockMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
/*
    @Test
    @DisplayName("우승자를 정상적으로 선출하는지 확인한다")
    void checkWinnerIsProperlySelected() {
        // given
        MovingStrategy movingStrategy = new MockMovingStrategy(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", movingStrategy).tryMove().tryMove(),
                RacingCar.of("red", movingStrategy).tryMove(),
                RacingCar.of("yellow", movingStrategy).tryMove().tryMove().tryMove()));
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
        MovingStrategy movingStrategy = new MockMovingStrategy(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", movingStrategy).tryMove().tryMove().tryMove(),
                RacingCar.of("red", movingStrategy).tryMove(),
                RacingCar.of("yellow", movingStrategy).tryMove().tryMove().tryMove()));
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
        MovingStrategy movingStrategy = new MockMovingStrategy(true);
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", movingStrategy).tryMove().tryMove().tryMove(),
                RacingCar.of("red", movingStrategy).tryMove().tryMove().tryMove(),
                RacingCar.of("yellow", movingStrategy).tryMove().tryMove().tryMove()));
        // when
        List<String> winners = racingCars.getWinners();
        // then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.get(0)).isEqualTo("blue");
        assertThat(winners.get(1)).isEqualTo("red");
        assertThat(winners.get(2)).isEqualTo("yellow");
    }
    */
}
