package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarRacingGameResultTest {

    @ParameterizedTest
    @MethodSource("provideCarRunResultPatterns")
    @DisplayName("게임이 끝난후 최종 주행거리가 가장 긴 차량의 이름을 반환한다.")
    void get_winner_names(List<Integer> runDistances, String expectedWinner) {

        CarRunResult carRunResult1 = new CarRunResult(new CarName("car1"), runDistances.get(0));
        CarRunResult carRunResult2 = new CarRunResult(new CarName("car2"), runDistances.get(1));
        CarRunResult carRunResult3 = new CarRunResult(new CarName("car3"), runDistances.get(2));

        List<CarRunResult> testCarRunResults = Arrays
            .asList(carRunResult1, carRunResult2, carRunResult3);

        Round round = new Round(testCarRunResults);

        CarRacingGameResult gameResult = new CarRacingGameResult(Collections.singletonList(round));

        assertThat(gameResult.getWinnerNames()).isEqualTo(expectedWinner);
    }

    private static Stream<Arguments> provideCarRunResultPatterns() {

        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), "car3"),
            Arguments.of(Arrays.asList(1, 2, 2), "car2,car3"),
            Arguments.of(Arrays.asList(2, 2, 2), "car1,car2,car3")
        );

    }
}