package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.strategy.impl.RandomBoundMovingStrategy;
import racingcar.util.InputCarNameSplitUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTests {

    @DisplayName("차 생성, 차들의 갯수 테스트(3개의 차 생성)")
    @ParameterizedTest
    @CsvSource({"pobi,crong,honux"})
    void createCarsTest(String input) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
        Cars cars = Cars.of(carNames);

        int actualSize = cars.getCarsCount();

        assertThat(actualSize).isEqualTo(carNames.length);
    }

    @DisplayName("차들의 초기 위치를 제대로 가져 올 수 있는지 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void getCarsPositionsTest(String input, List<Integer> expectedPositions) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
        Cars cars = Cars.of(carNames);

        List<Integer> actualPositions = cars.getCarsPositions();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("pobi,crong,honux", Arrays.asList(0, 0, 0)),
                Arguments.of("pobi,crong,honux,test1,test2", Arrays.asList(0, 0, 0, 0, 0)),
                Arguments.of("pobi,crong,honux,test1,test2,test3,test4", Arrays.asList(0, 0, 0, 0, 0, 0, 0))
        );
    }
}
