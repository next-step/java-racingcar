package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = {"2, 2", "3, 4", "5, 1"}, delimiter = ',')
    void constructor(int numberOfCar, int numberOfAttempts) {
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfAttempts);
        assertThat(racingGame.getNumberOfCars()).isEqualTo(numberOfCar);
        assertThat(racingGame.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 2", "3, 4", "5, 1"}, delimiter = ',')
    void hasNextRace(int numberOfCar, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;
        }

        assertThat(numberOfAttempts).isEqualTo(whileCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 2", "3, 4", "5, 1"}, delimiter = ',')
    void racing(int numberOfCar, int numberOfAttempts) {
        int whileCount = 0;

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfAttempts);

        while (racingGame.hasNextRace()) {
            racingGame.racing();
            whileCount++;

            assertThat(racingGame.getRound()).isEqualTo(whileCount);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4", "3, 6"}, delimiter = ',')
    void racingAll(int numberOfCar, int numberOfAttempts) {

        RacingGame racingGame = new RacingGame(numberOfCar, numberOfAttempts);
        racingGame.racingAll();

        assertThat(racingGame.getRound()).isEqualTo(numberOfAttempts);
    }
}