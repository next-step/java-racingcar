package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.race.controller.CarRacing;
import study.race.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static study.Step2.calculateString;


public class CarRacingTest {

    private static final String CAR_NAMES = "audi,benz,hd,kia";
    private static Cars stopCars;
    private static Cars moveCars;

    @BeforeAll
    static void init() {
        stopCars = new RacingRegister().register(CAR_NAMES);
        moveCars = new RacingRegister().register(CAR_NAMES);
    }

    @Test
    @DisplayName("Create Cars to Race")
    void generateCarsTest() {
        Cars cars = new RacingRegister().register(CAR_NAMES);
        assertThat(cars.size()).isEqualTo(CAR_NAMES.split(",").length);
    }

    @ParameterizedTest(name = "moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 4 or more, car moving Test")
    @CsvSource({"4, 1", "5, 2", "6, 3", "7, 4", "8, 5", "9, 6"})
    void moveCar(int movingDistance, int expected) {
        Car car = moveCars.get(0);
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "moving distance: {0}, current location: {1}")
    @DisplayName("When moving distance is 3 or less, car moving Test")
    @CsvSource({"0, 0", "1, 0", "2, 0", "3, 0"})
    void stopCar(int movingDistance, int expected) {
        Car car = stopCars.get(0);
        car.move(movingDistance);
        int result = car.getCurrentLocation();
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest()
    @DisplayName("Generating car as many as car names")
    @ValueSource(strings = {"car1,car2", "car1,car2,car3", "car1,car2,car3,car4"})
    void generateCarAsManyAsCarNames(String input) {
        Cars cars = new RacingRegister().register(input);
        assertThat(cars.size()).isEqualTo(input.split(",").length);
    }

    @ParameterizedTest()
    @DisplayName("Check for length of car's name greater than 5.")
    @ValueSource(strings = { "car1,superCar", "car1,car2,car34567", "audi,benz,hyundai,kia"})
    void checkLengthOfCarNameTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingRegister().register(input);
        });
    }

    @Test
    @DisplayName("Winner's Search Test")
    void checkWinners() {
        int maxDistance = 5;
        String name = "Car1";
        int distance = 5;

        Winners winners = new Winners(maxDistance);
        winners.checkAndAddWinner(name, distance);
        assertThat(winners.getWinnersList()).isEqualTo("Car1");
    }
}
