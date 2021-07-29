package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidCarNameException;
import racingcar.util.InputCarNameSplitUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTests {

    @DisplayName("차 생성, 차들의 갯수 테스트(3개의 차 생성)")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void createCarsTest(String input) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
        Cars cars = Cars.of(carNames);

        int actualSize = cars.getCarsCount();

        assertThat(actualSize).isEqualTo(carNames.length);
    }

    @DisplayName("차 생성, 차들의 갯수 테스트 문자열을 통째로 받는 생성자(3개의 차 생성)")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void createCarsDifferentConstructorTest(String input) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
        Cars cars = Cars.of(input);

        assertThat(cars.getCarsCount()).isEqualTo(carNames.length);
    }


    @DisplayName("차들의 초기 위치를 제대로 가져 올 수 있는지 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void getCarsPositionsTest(String input, List<Integer> expectedPositions) {
        String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
        Cars cars = Cars.of(carNames);

        List<Position> actualPositions = cars.getCarsPositions();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("pobi,crong,honux", Arrays.asList(new Position(0), new Position(0), new Position(0))),
                Arguments.of("pobi,crong,honux,test1,test2", Arrays.asList(new Position(0), new Position(0), new Position(0), new Position(0), new Position(0))),
                Arguments.of("pobi,crong,honux,test1,test2,test3,test4", Arrays.asList(new Position(0), new Position(0), new Position(0), new Position(0), new Position(0), new Position(0), new Position(0)))
        );
    }

    @DisplayName("차의 이름을 5글자 이상 넣었을 때 exception 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong123,honux"})
    void createCarNameOverFiveWordsExceptionTest(String input) {

        assertThatExceptionOfType(InvalidCarNameException.class)
                .isThrownBy(() -> {
                    String[] carNames = InputCarNameSplitUtils.getSplitStringArray(input);
                }).withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다 : crong123");

    }


}
