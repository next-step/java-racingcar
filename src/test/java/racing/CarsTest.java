package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.condition.FixedCondition;
import racing.domain.condition.RandomCondition;
import racing.view.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    private static final String COMMA = ",";
    private final String TEST_CAR_NAME = "T_CAR";
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
            assertEquals(expectedPosition, car.position());
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

    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"A,B,C", "D,E", "Q,W,E,R,T"}, delimiter = ' ')
    public void giveCarNames(String carNamesInput) {
        //given when
        List<String> carNames = Arrays.asList(carNamesInput.split(COMMA));
        Cars cars = new Cars(carNames, new FixedCondition(ALWAYS_TRUE_CONDITION));

        //then
        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.getCars().get(i).carName());
        }
    }

    @Test
    @DisplayName("자동차의 이름은 5자를 초과할 수 없다")
    public void carNameCanNotExceedFive(){
        //given
        String failName = TEST_CAR_NAME + TEST_CAR_NAME;
        List<String> carNames = Arrays.asList(failName.split(COMMA));

        //when then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cars(carNames, new FixedCondition(ALWAYS_TRUE_CONDITION)))
                .withMessageMatching("자동차의 이름은 5자를 초과할 수 없습니다");
    }
}
