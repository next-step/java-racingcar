package step33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    private Car car;
    private RandomGenerator randomGenerator;
    private  CarRacing carRacing;

    @BeforeEach
    void init() {
        car = new Car(new ArrayList<>());
        randomGenerator = new RandomGenerator(new Random());
        carRacing = new CarRacing(car, randomGenerator);
    }

    @DisplayName("createCar를 정상적으로 호출했을 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void createCarTest(int number) {
        assertDoesNotThrow(() -> carRacing.createCars(number));
        assertEquals(car.carsSizes().size(), number);
    }

    @DisplayName("start를 정상적으로 호출했을 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void startTest(int number) {
        carRacing.createCars(1);
        List<CarResponse> start = carRacing.start(number);

        Assertions.assertEquals(start.size(), number);
    }

}