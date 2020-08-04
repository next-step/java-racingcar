package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void constructor(String namesOfCarsText, int numberOfAttempts) {
        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);
        assertThat(racingGame.getNumberOfCars()).isEqualTo(namesOfCarsText.split(",").length);
        assertThat(racingGame.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
    }

    @ParameterizedTest
    @CsvSource(value = {"yongdae", "tester"})
    void constructorWithThrowRuntimeException(String namesOfCarsText) {
        assertThatThrownBy(() -> {
            RacingGame racingGame = new RacingGame(namesOfCarsText, 0);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void hasNextRace(String namesOfCarsText, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;
        }

        assertThat(numberOfAttempts).isEqualTo(whileCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void racing(String namesOfCarsText, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;

            assertThat(racingGame.getRound()).isEqualTo(whileCount);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"kyd | 2", "kyd, one | 4", "kyd, one, two | 1"}, delimiter = '|')
    void racingAll(String namesOfCarsText, int numberOfAttempts) {

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);
        racingGame.racingAll();

        assertThat(racingGame.getRound()).isEqualTo(numberOfAttempts);
    }
}