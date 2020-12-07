package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    private static final String COMMA = ",";
    private final String TEST_CAR_NAME = "TEST_CAR";
    private final int ALWAYS_TRUE_CONDITION = 9;

    @DisplayName("경기에 참가하는 자동차의 대수는 사용자가 정한다")
    @ParameterizedTest
    @CsvSource(value = {"A,B,C: 3", "D,E: 2", "Q,W,E,R,T: 5"}, delimiter = ':')
    public void numberOfCars(String carNamesInput, int expected) {
        //given
        List<String> carNames = Arrays.asList(carNamesInput.split(COMMA));
        Cars cars = new Cars(carNames, new RandomCondition());

        //then
        assertEquals(expected, cars.getCars().size());
        assertEquals(carNames.size(), cars.getCars().size());
    }

    @DisplayName("여러대의 자동차가 이동 요구사항을 만족하면서 이동한다")
    @ParameterizedTest
    @CsvSource(value = {"3, 0", "5, 1", "7, 1"})
    public void expectedMove(int RandomCondition, int expectedPosition) {
        //given
        Cars cars = new Cars(Arrays.asList(TEST_CAR_NAME, TEST_CAR_NAME), new FixedCondition(RandomCondition));

        //when
        cars.move();

        //then
        for (Car car : cars.getCars()) {
            assertEquals(expectedPosition, car.getPosition());
        }
    }

    @DisplayName("자동차의 이름은 쉼표(,)를 기준으로 구분한다")
    @ParameterizedTest
    @CsvSource(value = {"A,B,C:,:true", "D,E:#:false", "Q,W,E,R,T:,:true"}, delimiter = ':')
    public void SeparateWithCommas(String carNamesInput, String Separator, boolean expected) {
        // when
        List<String> expectedCarNames = Arrays.asList(carNamesInput.split(Separator));
        List<String> inputCarNames = InputView.inputSplit(carNamesInput);

        //then
        assertEquals(expected, expectedCarNames.containsAll(inputCarNames));
    }
}
