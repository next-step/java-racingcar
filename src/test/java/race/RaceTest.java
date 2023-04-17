package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    @ParameterizedTest(name = "이동 전략이 {0} 이면 자동차 경주 단판 결과는 {1} 이다")
    @MethodSource("oneLapTestStubs")
    void 자동차_경주_단판_결과를_알_수_있다(MoveStrategy moveStrategy, List<Integer> positions) {
        Cars cars = new Cars(3, moveStrategy);
        Race race = new Race(cars);
        assertThat(race.startLap()).isEqualTo(positions);
    }

    private static Stream<Arguments> oneLapTestStubs() {
        return Stream.of(
                Arguments.arguments(new TestHelper.AlwaysMoveStrategy(), List.of(1, 1, 1)),
                Arguments.arguments(new TestHelper.NeverMoveStrategy(), List.of(0, 0, 0))
        );
    }
}
