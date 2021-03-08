package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    List<Car> cars;
    CarRacing carRacing;

    @BeforeEach
    void init() {
        cars = new ArrayList<>();
        carRacing = new CarRacing(cars);
    }

    @DisplayName("CarRacing CreateCar 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void carRacingCreateCarsTest(int amountOfCar){
        carRacing.createCars(amountOfCar);

        Assertions.assertEquals(amountOfCar, cars.size());
    }

    @DisplayName("CarRacing MoveCars 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void carRacingMoveCarsTest(int countOfCarRacing) {
        Car car = new Car(1);
        cars.add(car);
        carRacing.moveCars(countOfCarRacing);

        Assertions.assertEquals(0 , cars.size());
    }

    @DisplayName("CarRacing MoveCars 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:4", "3:10", "20:40"} , delimiter = ':')
    void test005(int amountOfCar, int countOfCarRacing) {

        carRacing.createCars(amountOfCar);
        carRacing.moveCars(countOfCarRacing);

        Assertions.assertEquals(0 , cars.size());
    }


}