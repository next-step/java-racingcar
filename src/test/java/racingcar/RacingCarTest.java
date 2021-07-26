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
    @CsvSource({"3, 5"})
    public void createAsCarsNumberOfEnteredByUser(int carCount ,int moveCount) {
        RacingCar racingCar = new RacingCar(carCount, moveCount);
        List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();

        assertThat(cars.size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource({"2, 4"})
    public void moveAsCarUserEntered(int carCount ,int moveCount) {
        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carCount, moveCount);
            List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();
            racingCar.moveAsCarUserEntered(cars);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"3, 2"})
    public void doRacingStart(int carCount ,int moveCount) {
        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carCount, moveCount);
            List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();
            racingCar.doRacingStart(cars);
        }).doesNotThrowAnyException();
    }

}