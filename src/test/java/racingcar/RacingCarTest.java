/*
 *   Class name : RacingCarTest.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RacingCarTest {

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 5"})
    public void createAsCarsNumberOfEnteredByUser(String input ,int moveCount) {
        String[] carNames  = input.split(";");
        RacingCar racingCar = new RacingCar(carNames, moveCount);
        List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();

        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 2"})
    public void moveAsCarUserEntered(String input ,int moveCount) {
        String[] carNames  = input.split(";");

        assertThatCode(() -> {
            RacingCar racingCar = new RacingCar(carNames, moveCount);
            List<Car> cars = racingCar.createAsCarsNumberOfEnteredByUser();
            racingCar.moveAsCarUserEntered(cars);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 4"})
    public void getWinners(String input ,int moveCount) {
        String[] carNames  = input.split(";");
        RacingCar racingCar = new RacingCar(carNames, moveCount);

        List<Car> beforeRacingCars = racingCar.moveAsCarUserEntered(racingCar.createAsCarsNumberOfEnteredByUser());
        List<Car> winners = racingCar.getWinners(beforeRacingCars);
        int winnerLocation = racingCar.getWinnerLocation(beforeRacingCars);

        for (Car winner : winners) {
            assertThat(winner.getCurrentLocation()).isEqualTo(winnerLocation);
        }
    }

    @ParameterizedTest
    @CsvSource({"apple;banana;orange, 4"})
    public void getWinnerLocation(String input ,int moveCount) {
        String[] carNames  = input.split(";");
        RacingCar racingCar = new RacingCar(carNames, moveCount);

        Car car0 = new Car(carNames[0]);
        Car car1 = new Car(carNames[1]);
        Car car2 = new Car(carNames[2]);

        car0.moveCar(3);
        car1.moveCar(4);
        car2.moveCar(5);

        List<Car> cars = new ArrayList<Car>();
        cars.add(car0);
        cars.add(car1);
        cars.add(car2);

        int winnerLocation = racingCar.getWinnerLocation(cars);

        assertThat(winnerLocation).isEqualTo(car2.getCurrentLocation());

    }

}