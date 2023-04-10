package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RacingSupporterTest {


    @ParameterizedTest
    @DisplayName("입력한 수에 맞게 자동차가 생성된다.")
    @ValueSource(ints = {1,2,10})
    void generateCarList(int carCount) {
        assertThat(RacingSupporter.generateCarList(carCount)).hasSize(carCount);
    }
    @ParameterizedTest
    @DisplayName("주어진 배열에 따라 자동차가 움직인다.")
    @MethodSource("generateRandomListAndExpectedPositionList")
    void raceCars(List<Integer> randomList, int carNumber, List<Integer> expectedPositionList) {
        Cars cars = new Cars(RacingSupporter.generateCarList(carNumber));
        RacingSupporter.raceCars(cars,randomList);
        List<Integer> carsPosition = cars.valueOfCarsPosition();
        assertThat(carsPosition).hasSize(carNumber);
        for (int i = 0; i < carNumber; i++) {
            assertThat(carsPosition.get(i)).isEqualTo(expectedPositionList.get(i));
        }
    }

    private static Stream<Arguments> generateRandomListAndExpectedPositionList() {
        return Stream.of(
                Arguments.of(Arrays.asList(0,3,4,9),4,Arrays.asList(0,0,1,1)),
                Arguments.of(Arrays.asList(1,2),2,Arrays.asList(0,0)),
                Arguments.of(Arrays.asList(4,4,9),3,Arrays.asList(1,1,1))
        );
    }

    @ParameterizedTest
    @DisplayName("숫자에따라 자동차가 움직인다.")
    @CsvSource(value = {"3,0", "4,1", "0,0", "9,1"})
    void judgeRace(int number, int expectedPosition) {
        Car car = new Car();
        RacingSupporter.judgeRace(car, number);
        assertThat(car.valueOfCurrentPosition()).isEqualTo(expectedPosition);
    }

}
