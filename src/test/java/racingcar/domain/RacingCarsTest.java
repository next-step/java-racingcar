package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movingstrategy.AlwaysGoStrategy;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RacingCarsTest {

    @Test
    @DisplayName("toString 테스트: 등록된 차들의 이름이 ', '로 join하어 리턴한다.")
    void toString테스트() {
        RacingCar racingCar1 = new RacingCar(new RacingCarName("a"), new AlwaysGoStrategy());
        RacingCar racingCar2 = new RacingCar(new RacingCarName("b"), new AlwaysGoStrategy());

        RacingCars racingCars = new RacingCars(Arrays.asList(racingCar1, racingCar2));

        String expectedResult = "a, b";

        assertEquals(expectedResult, racingCars.toString());
    }

    @Test
    @DisplayName("getFarthestRacingCars 테스트: position이 가장 큰 자동차들(RacingCars)를 리턴한다.")
    void getFarthestRacingCars() {
        RacingCar racingCar1 = new RacingCar(new RacingCarName("a"), new AlwaysGoStrategy());
        RacingCar racingCar2 = new RacingCar(new RacingCarName("b"), new AlwaysGoStrategy());

        racingCar1.move();
        racingCar1.move();
        racingCar2.move();

        RacingCars racingCars = new RacingCars(Arrays.asList(racingCar1, racingCar2));

        RacingCars farthestRacingCars = racingCars.getFarthestRacingCars();

        RacingCars expectedResult = new RacingCars(Collections.singletonList(racingCar1));

        assertEquals(expectedResult, farthestRacingCars);
    }

}
