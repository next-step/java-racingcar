package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {
    String carNames = "bmw,benz,audi";
    Racing racingWithLambda = new Racing(carNames, (int value) -> true);
    Racing racingWithImpl = new Racing(carNames, new TestMoveStrategy());

    @Test
    @DisplayName("이동 test")
    void raceTest() {
        for(int i =0; i < 5; i++) {
            racingWithLambda.race();
        }
        for(int i =0; i < 3; i++) {
            racingWithImpl.race();
        }

        List<Car> result = racingWithLambda.getRacingCars();
        List<Car> result2 = racingWithImpl.getRacingCars();
        assertAll("racing",
                () -> assertEquals(result.get(0).getPosition().getPosition(), 5),
                () -> assertEquals(result.get(1).getPosition().getPosition(), 5),
                () -> assertEquals(result.get(2).getPosition().getPosition(), 5),
                () -> assertEquals(result2.get(0).getPosition().getPosition(), 3),
                () -> assertEquals(result2.get(1).getPosition().getPosition(), 3),
                () -> assertEquals(result2.get(2).getPosition().getPosition(), 3));

    }

    @Test
    @DisplayName("자동차 이름 test")
    void carNameCheckTest() {
        List<Car> cars = racingWithLambda.getRacingCars();
        assertAll("racing",
                () -> assertEquals(cars.get(0).getName(), "bmw"),
                () -> assertEquals(cars.get(1).getName(), "audi"),
                () -> assertEquals(cars.get(2).getName(), "benz"))
                ;

    }
}