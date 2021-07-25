/*
 *   Class name : RacingCarTest.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingCar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest
    @CsvSource({"2,4"})
    public void readyCar(int carCount, int moveCount) {
        RacingCar racingCar = new RacingCar(carCount,moveCount);
        List<Car> cars = racingCar.readyCar();

        assertThat(cars.size()).isEqualTo(carCount);
    }

    @ParameterizedTest
    @CsvSource({"3,5"})
    public void getMove(int carCount, int moveCount) {
      RacingCar racingCar = new RacingCar(carCount, moveCount);

      assertThat(racingCar.getMove()).isNotNull();
      assertThat(racingCar.getMove()).isBetween(0,10);
    }
}