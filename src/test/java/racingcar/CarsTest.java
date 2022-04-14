package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = {"1", "2", "3", "4", "5"};
        cars = Cars.generateCars(carNames);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1,1,1,1:1,1,1,1,1",
            "5,5,5,5,5:2,2,2,2,2",
            "4,5,6,1,7:1,2,2,1,2"
    }, delimiter = ':')
    @DisplayName("이동 후 현재 위치 목록 반환")
    void returnCurrentLocationsAfterMove(String moveCountsString, String expectedString) {
        List<Integer> moveCounts = convertStringToIntArray(moveCountsString);
        cars.move(moveCounts);

        List<Integer> expected = convertStringToIntArray(expectedString);
        assertThat(cars.getCurrentLocations()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1","1:2","2:3","3:4","4:5"}, delimiter = ':')
    @DisplayName("carList 반환")
    void returnCarList(int index, String name) {
        List<Car> carList = cars.getCarList();
        assertThat(carList).hasSize(5);
        assertThat(carList.get(index).getCarName()).isEqualTo(name);
    }

    private List<Integer> convertStringToIntArray(String moveCountsString) {
        return Arrays.stream(moveCountsString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}