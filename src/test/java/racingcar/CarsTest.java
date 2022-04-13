package racingcar;

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

    @ParameterizedTest
    @CsvSource(value = {
            "1,1,1,1,1:1,1,1,1,1",
            "5,5,5,5,5:2,2,2,2,2",
            "4,5,6,1,7:1,2,2,1,2"
    }, delimiter = ':')
    @DisplayName("이동 후 현재 위치 목록 반환")
    void returnCurrentLocationsAfterMove(String moveCountsString, String expectedString) {
        // given
        Cars cars = Cars.generateCars(5);
        // when
        List<Integer> moveCounts = convertStringToIntArray(moveCountsString);
        cars.move(moveCounts);
        // then
        List<Integer> expected = convertStringToIntArray(expectedString);
        assertThat(cars.getCurrentLocations()).isEqualTo(expected);
    }

    private List<Integer> convertStringToIntArray(String moveCountsString) {
        return Arrays.stream(moveCountsString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}