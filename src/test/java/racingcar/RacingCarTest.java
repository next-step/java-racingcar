package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName(value = "Car is starting position is 0")
    @Test
    void startingPositionOfTheCarIsZero() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getPosition())
                .isEqualTo(0);
    }

    @DisplayName(value = "Confirm Car Progress")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void carMove(int numberOfCar) {
        RacingCars racingCars = new RacingCars(numberOfCar);
        racingCars.racingAttempt();
        List<Integer> results = racingCars.getResultAttempt();
        assertThat(results.size()).isEqualTo(numberOfCar);
    }

    @DisplayName(value = "Confirm Car 4 or more and less than 4 operation")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1", "8:1"}, delimiter = ':')
    void racingCarMove(int randomNumber, int expect) {
        RacingCar racingCar = new RacingCar();
        racingCar.moveOrStop(randomNumber);
        int result = racingCar.getPosition();
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName(value = "Confirm Race Progress")
    @ParameterizedTest
    @CsvSource(value = {"3:5", "1:3", "4:6"}, delimiter = ':')
    void startRace(int numberOfCar, int numberOfAttempt) {
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfAttempt);
        List<RacingResult> result = racingGame.startRace();

        assertThat(result.get(0).getPositions().size()).isEqualTo(numberOfCar);
        assertThat(result.size()).isEqualTo(numberOfAttempt);
    }

}
