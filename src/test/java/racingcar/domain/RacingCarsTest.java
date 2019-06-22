package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.Position;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    @DisplayName("우승자를 정상적으로 가져오는지 확인한다")
    void checkWinners() {
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", Position.of(10)),
                RacingCar.of("red", Position.of(5)),
                RacingCar.of("yellow", Position.of(7))
        ));
        // when
        List<RacingCar> winners = racingCars.findWinners();
        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getPosition()).isEqualTo(10);
    }

    @Test
    @DisplayName("우승자가 2명인경우 정상적으로 가져오는지 확인한다")
    void checkWinners2() {
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", Position.of(10)),
                RacingCar.of("red", Position.of(10)),
                RacingCar.of("yellow", Position.of(7))
        ));
        // when
        List<RacingCar> winners = racingCars.findWinners();
        // then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getPosition()).isEqualTo(10);
        assertThat(winners.get(1).getPosition()).isEqualTo(10);
    }

    @Test
    @DisplayName("모두 우승한경우 정상적으로 가져오는지 확인한다")
    void checkWinners3() {
        // given
        RacingCars racingCars = RacingCars.of(Arrays.asList(
                RacingCar.of("blue", Position.of(10)),
                RacingCar.of("red", Position.of(10)),
                RacingCar.of("yellow", Position.of(10))
        ));
        // when
        List<RacingCar> winners = racingCars.findWinners();
        // then
        assertThat(winners.size()).isEqualTo(3);
        assertThat(winners.get(0).getPosition()).isEqualTo(10);
        assertThat(winners.get(1).getPosition()).isEqualTo(10);
        assertThat(winners.get(2).getPosition()).isEqualTo(10);
    }
}
