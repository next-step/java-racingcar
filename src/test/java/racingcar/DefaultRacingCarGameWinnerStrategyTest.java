package racingcar;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DefaultRacingCarGameWinnerStrategyTest {

    @Test
    void 동점이면_모두_winner다() {
        List<RacingCar> racingCars = RacingCarFactory.createRacingCars(new String[]{
            "1", "2", "3", "4"
        }, () -> true);

        racingCars.get(0).moveIfMovable();
        racingCars.get(1).moveIfMovable();
        racingCars.get(1).moveIfMovable();
        racingCars.get(2).moveIfMovable();
        racingCars.get(2).moveIfMovable();
        racingCars.get(3).moveIfMovable();
        racingCars.get(3).moveIfMovable();

        DefaultRacingCarGameWinnerStrategy defaultRacingCarGameWinnerStrategy
            = DefaultRacingCarGameWinnerStrategy.getInstance();

        List<RacingCar> winners = defaultRacingCarGameWinnerStrategy.getWinners(racingCars);

        assertThat(winners).contains(racingCars.get(1));
        assertThat(winners).contains(racingCars.get(2));
        assertThat(winners).contains(racingCars.get(3));
    }

    @Test
    void 빈_리스트를_전달하면_빈_리스트를_반환한다() {
        DefaultRacingCarGameWinnerStrategy winnerStrategy
            = DefaultRacingCarGameWinnerStrategy.getInstance();

        List<RacingCar> winners = winnerStrategy.getWinners(Collections.emptyList());

        assertThat(winners).isEmpty();
    }

}
