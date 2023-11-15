package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.race.controller.CarRacing;
import study.race.model.*;

import static org.assertj.core.api.Assertions.assertThat;


public class CarRacingTest {

    private static final int NUMBER_OF_CAR = 3;
    private static final String CAR_NAMES = "audi,benz,hd,kia";
    private static String[] carNames;
    private static Cars stopCars;
    private static Cars moveCars;

    @BeforeAll
    static void init() {
        carNames = CAR_NAMES.split(",");
        stopCars = new CarListGenerator().generateCarList(carNames);
        moveCars = new CarListGenerator().generateCarList(carNames);
    }

    @Test
    @DisplayName("Create Cars to Race")
    void generateCarListTest() {
        Cars cars = new CarListGenerator().generateCarList(carNames);
        assertThat(cars.carList().size()).isEqualTo(carNames.length);
    }

    @ParameterizedTest()
    @DisplayName("When moving distance is 3 or less, car initial movement Test")
    @CsvSource({"0, 1", "1, 1", "2, 1", "3, 1"})
    void initialMoveCar() {
        Cars cars = new CarListGenerator().generateCarList(carNames);
        Car car = cars.carList().get(0);
        car.move(1);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest(name = "moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 4 or more, car moving Test")
    @CsvSource({"4, 1", "5, 2", "6, 3", "7, 4", "8, 5", "9, 6"})
    void moveCar(int movingDistance, int expected) {
        Car car = moveCars.carList().get(0);
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 3 or less, car moving Test")
    @CsvSource({"0, 1", "1, 1", "2, 1", "3, 1"})
    void stopCar(int movingDistance, int expected) {
        Car car = stopCars.carList().get(0);
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest()
    @DisplayName("Result of racing update Test")
    @CsvSource({"3, 1", "5, 2", "7, 3", "2, 3"})
    void updateRaceResult(int movingDistance, int expected) {
        RaceResult raceResult = new RaceResult(stopCars);

        // 차량 이동 및 결과 업데이트
        stopCars.carList().get(0).move(movingDistance);
        raceResult.updateRaceResult();

        // 결과 확인
        int[] result = raceResult.getResult();
        assertThat(result[0]).isEqualTo(expected);
    }

    @ParameterizedTest()
    @DisplayName("Generating car as many as car names")
    @ValueSource(strings = {"car1,car2", "car1,car2,car3", "car1,car2,car3,car4"})
    void generateCarAsManyAsCarNames(String input) {
        String[] names = input.split(",");
        Cars cars = new CarListGenerator().generateCarList(names);
        assertThat(cars.carList().size()).isEqualTo(names.length);
    }

//    @ParameterizedTest()
//    @DisplayName("Check for length of car's name greater than 5.")
//    @ValueSource(strings = { "car1,superCar", "car1,car2,car34567", "audi,benz,hyundai,kia"})
//    void checkLengthOfCarNameTest(String input) {
//        String[] names = input.split(",");
//
//        new CarRacingInputManager().getRaceInfo();
//
//        boolean result = new CarRacing().checkLengthLimitOfCarName(names);
//        assertThat(result).isEqualTo(false);
//    }
}
