package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step3.model.RacingGame;
import study.step3.model.car.Car;
import study.step3.model.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1"})
    @DisplayName("Car Move Test")
    void carMoveTest(int inputCarDistance, int expectedCarDistance) {
        int userCarNumber = 3;
        int userGameRound = 5;
        RacingGame racingGame = new RacingGame(userCarNumber, userGameRound);

        for (Car car : racingGame.getCars().getRacingGameCars()) {
            car.move(new RandomMoveStrategy(inputCarDistance));
            assertThat(car.getDistance()).isEqualTo(expectedCarDistance);
        }
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,0", "3,0"})
    @DisplayName("Car Stop Test")
    void carStopTest(int inputCarDistance, int expectedCarDistance) {
        int userCarNumber = 3;
        int userGameRound = 5;
        RacingGame racingGame = new RacingGame(userCarNumber, userGameRound);

        for (Car car : racingGame.getCars().getRacingGameCars()) {
            car.move(new RandomMoveStrategy(inputCarDistance));
            assertThat(car.getDistance()).isEqualTo(expectedCarDistance);
        }
    }
}
