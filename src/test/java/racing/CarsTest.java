package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @DisplayName("경기에 참가하는 자동차의 대수는 사용자가 정한다")
    @ParameterizedTest
    @CsvSource(value = {"3, 3", "5, 5", "7, 7"})
    public void numberOfCars(int count, int expected) {
        //given
        Cars cars = new Cars(count, new RandomCondition());

        //then
        assertEquals(expected, cars.getCars().size());
    }

    @DisplayName("여러대의 자동차가 이동 요구사항을 만족하면서 이동한다")
    @ParameterizedTest
    @CsvSource(value = {"3, 3, 0", "5, 5, 1", "7, 7, 1"})
    public void expectedMove(int count, int condition, int expectedPosition) {
        //given
        Cars cars = new Cars(count, new FixedCondition(condition));

        //when
        cars.move();

        //then
        for (Car car : cars.getCars()) {
            assertEquals(expectedPosition, car.getPosition());
        }
    }
}
