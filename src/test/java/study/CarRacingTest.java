package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.race.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarRacingTest {


    @Test
    @DisplayName("Create Cars to Race")
    void generateCarListTest() {
        int numberOfCars = 3;
        List<Car> carList = new CarListGenerator(3).generateCarList();
        assertThat(carList.size()).isEqualTo(numberOfCars);
    }

    @ParameterizedTest(name="moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 4 or more, Car moving Test")
    @CsvSource({ "4, 5", "5, 6", "6, 7", "7, 8", "8, 9", "9, 10"})
    void moveCar(int movingDistance, int expected) {
        Car car = new Car();
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name="moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 3 or less, Car moving Test")
    @CsvSource({ "0, 1", "1, 1", "2, 1", "3, 1"})
    void stopCar(int movingDistance, int expected) {
        Car car = new Car();
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Result of racing update Test")
    void updateRaceResult() {
        int numberOfCar = 3;
        int[] movingDistanceList = {3, 5, 7};
        int[] expected = {1, 6, 8};
        List<Car> carList = new CarListGenerator(numberOfCar).generateCarList();
        RaceResult raceResult = new RaceResult(carList);

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move(movingDistanceList[i]);
        }
        raceResult.updateRaceResult();

        int[] result = raceResult.getResult();  // 1, 6, 8

        for (int i = 0; i < carList.size(); i++){
            assertThat(result[i]).isEqualTo(expected[i]);
        }
    }
}
