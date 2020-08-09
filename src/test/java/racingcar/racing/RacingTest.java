package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.racing.Racing.*;

public class RacingTest {
    @Test
    void 경주시작_임의값_성공(){
        racingStart(3, 5);
    }

    @Test
    void 자동차_초기화_성공() {
        assertEquals(3, initCars(3).size());
    }

    @Test
    void 레이싱_결과_성공() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());

        resultView(cars, 5);
    }
}
