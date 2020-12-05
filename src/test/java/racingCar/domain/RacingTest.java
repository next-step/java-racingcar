package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

    Racing racingWithLambda = new Racing(3, (int value) -> true);
    Racing racingWithImpl = new Racing(3, new TestMoveStrategy());

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
                () -> assertEquals(result.get(0).getPosition(), 5),
                () -> assertEquals(result.get(1).getPosition(), 5),
                () -> assertEquals(result.get(2).getPosition(), 5),
                () -> assertEquals(result2.get(0).getPosition(), 3),
                () -> assertEquals(result2.get(1).getPosition(), 3),
                () -> assertEquals(result2.get(2).getPosition(), 3));

    }


}
