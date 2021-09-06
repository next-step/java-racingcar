package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingResults;

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

    @DisplayName(value = "Confirm Race Progress")
    @ParameterizedTest
    @CsvSource("pobi,crong,honux")
    void carMove(String car1, String car2, String car3) {
        String[] names = {car1, car2, car3};
        RacingCars racingCars = new RacingCars(names);
        racingCars.racingAttempt();
        List<RacingCar> racingCarList = racingCars.getRacingCars();

        assertThat(racingCarList.size()).isEqualTo(names.length);
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
    @CsvSource(value = {"3,pobi,crong,honux", "4,pobi,crong,honux,sun"})
    void startRace(int attempt, String car1, String car2, String car3) {
        String[] names = {car1, car2, car3};
        List<RacingResults> results = RacingGame.startRace(attempt, names);

        assertThat(results.size()).isEqualTo(attempt);
        assertThat(results.get(0).getRacingResults().size()).isEqualTo(names.length);
    }

}
