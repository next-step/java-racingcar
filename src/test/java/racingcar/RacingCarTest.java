/*
 *   Class name : RacingCarTest.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RacingCarTest {

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 5"})
    public void createAsCarsNumberOfEnteredByUser(String input ,int moveCount) {
        String[] carNames  = input.split(";");
        RacingCar racingCar = new RacingCar(carNames, moveCount , 10);
        List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();

        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 2"})
    public void moveAsCarUserEntered(String input ,int moveCount) {
        String[] carNames  = input.split(";");

        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carNames, moveCount ,10);
            List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();
            racingCar.moveAsCarUserEntered(cars);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 4"})
    public void doRacingStart(String input ,int moveCount) {
        String[] carNames  = input.split(";");

        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carNames, moveCount, 10);
            List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();
            racingCar.doRacingStart(cars);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 4"})
    public void getWinners(String input ,int moveCount) {
        String[] carNames  = input.split(";");
        RacingCar racingCar = new RacingCar(carNames, moveCount, 10);

        racingCar.start();

        List<Car> cars = racingCar.getCars();
        List<Car> winners = racingCar.getWinners(cars);

        int winnerLocation = racingCar.getWinnerLocation(cars);

        for (Car car : winners) {
            assertThat(car.getCurrentLocation()).isEqualTo(winnerLocation);
        }
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 4"})
    public void start(String input ,int moveCount) {
        String[] carNames  = input.split(";");

        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carNames, moveCount, 10);
            racingCar.start();
        }).doesNotThrowAnyException();
    }

}