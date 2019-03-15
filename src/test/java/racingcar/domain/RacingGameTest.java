package racingcar.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private static final int TEST_VERY_EASY_DIFFICULTY = 0;
    private static final int TEST_VERY_DIFFICULT_DIFFICULTY = 10;
    private static final String[] TEST_NAMES = {"pobi", "crong", "honux"};

    @Test
    public void 자동차_생성() {
        // given
        // when
        final RacingGame racingGame = new RacingGame(TEST_VERY_EASY_DIFFICULTY, TEST_NAMES);
        final RacingCars racingCars = racingGame.getRacingCars();

        // then
        assertThat(racingCars.get()).hasSize(TEST_NAMES.length);
    }

    @Test
    public void 경주_모두_이동하는_경우() {
        // given
        final RacingGame racingGame = new RacingGame(TEST_VERY_EASY_DIFFICULTY, TEST_NAMES);

        // when
        final RacingCars racingCarsAfterRace = racingGame.race();

        // then
        final List<RacingCar> movedRacingCars = getMovedRacingCars(racingCarsAfterRace);
        assertThat(movedRacingCars).hasSize(racingCarsAfterRace.get().size());
    }

    @Test
    public void 경주_모두_이동하지_않는_경우() {
        // given
        final RacingGame racingGame = new RacingGame(TEST_VERY_DIFFICULT_DIFFICULTY, TEST_NAMES);

        // when
        final RacingCars racingCarsAfterRace = racingGame.race();

        // then
        final List<RacingCar> movedRacingCars = getMovedRacingCars(racingCarsAfterRace);
        assertThat(movedRacingCars).isEmpty();
    }

    @Test
    public void 누가_우승했는지() {
        // given
        final RacingGame racingGame = new RacingGame(TEST_VERY_DIFFICULT_DIFFICULTY, TEST_NAMES);

        // when
        final RacingCars winners = racingGame.whoIsTheWinner();

        // then
        assertThat(getRacingCarNames(winners)).contains(TEST_NAMES);
    }

    private List<RacingCar> getMovedRacingCars(final RacingCars racingCars) {
        return racingCars.get()
                .stream()
                .filter(racingCar -> racingCar.getPosition() > 0)
                .collect(Collectors.toList())
                ;
    }

    private List<String> getRacingCarNames(final RacingCars winners) {
        return winners.get()
                .stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList())
                ;
    }
}
