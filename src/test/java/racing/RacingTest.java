package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.condition.FixedCondition;
import racing.domain.Racing;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {
    private final String TEST_CAR_NAME = "T_CAR";

    @DisplayName("자동차가 몇 번의 이동을 할지는 사용자가 정한다")
    @ParameterizedTest
    @CsvSource(value = {"4, 3", "4, 5"})
    public void carsMove(int condition, int movingCount) {
        //given
        Cars cars = new Cars(Arrays.asList(TEST_CAR_NAME, TEST_CAR_NAME), new FixedCondition(condition));
        Racing racing = new Racing(movingCount, cars);

        //when
        racing.start();

        //then
        for (Car car : cars.getCars()) {
            assertEquals(movingCount, car.position());
        }
    }
}
