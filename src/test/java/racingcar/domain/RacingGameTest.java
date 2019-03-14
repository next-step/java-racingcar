package racingcar.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    public void 자동차_생성() {
        // given
        final RacingGame racingGame = new RacingGame(0);
        final int numberOfCars = 3;

        // when
        final List<RacingCar> racingCars = racingGame.makeRacingCars(numberOfCars);

        // then
        assertThat(racingCars).hasSize(numberOfCars);
    }

    @Test
    public void 경주_모두_이동하는_경우() {
        // given
        final RacingGame racingGame = new RacingGame(0);
        final List<RacingCar> racingCars = Arrays.asList(new RacingCar(1), new RacingCar(2), new RacingCar(3));

        // when
        racingGame.race(racingCars);

        // then
        final List<RacingCar> racingCarsAfterRace = racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() > 0)
                .collect(Collectors.toList())
                ;
        assertThat(racingCarsAfterRace).hasSize(racingCars.size());
    }

    @Test
    public void 경주_모두_이동하지_않는_경우() {
        // given
        final RacingGame racingGame = new RacingGame(9);
        final List<RacingCar> racingCars = Arrays.asList(new RacingCar(1), new RacingCar(2), new RacingCar(3));

        // when
        racingGame.race(racingCars);

        // then
        final List<RacingCar> racingCarsAfterRace = racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() > 0)
                .collect(Collectors.toList())
                ;
        assertThat(racingCarsAfterRace).isEmpty();
    }
}
