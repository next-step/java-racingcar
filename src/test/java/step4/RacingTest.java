package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class RacingTest {
    Car car;
    Racing racing;
    OutputRacingCar outputResult;

    @BeforeEach
    void init() {
        racing = new Racing();
        outputResult = new OutputRacingCar();
    }



    @Test
    void racingTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test0", new Position()));
        cars.add(new Car("test1", new Position()));
        cars.add(new Car("test2", new Position()));

        racing.racing(cars, 3, outputResult);
    }
}
