package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {

    @DisplayName("자동차가 몇 번의 이동을 할지는 사용자가 정한다")
    @ParameterizedTest
    @CsvSource(value = {"3, 4, 5", " 5, 4, 5"})
    public void carsMove(int numberOfCars, int condition, int movingCount) {
        //given
        Cars cars = new Cars(numberOfCars, new FixedCondition(condition));
        Racing racing = new Racing(movingCount, cars);

        //when
        racing.start();

        //then
        for (Car car : cars.getCars()) {
            assertEquals(movingCount, car.getPosition());
        }
    }
}
