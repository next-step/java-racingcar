package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RaceTest {
    @ParameterizedTest(name = "이동 전략이 {0} 이면 자동차 경주 단판 결과는 {1} 이다")
    @MethodSource("oneLapTestStubs")
    void 자동차_경주_단판_결과를_알_수_있다(MoveStrategy moveStrategy, List<Integer> positions) {
        List<CarName> carNameList = List.of(new CarName("a"), new CarName("b"), new CarName("c"));
        Cars cars = new Cars(carNameList, moveStrategy);
        Race race = new Race(cars);
        assertThat(race.startLap()
                .stream()
                .map(CarResult::getPosition)
                .collect(Collectors.toList())
        ).isEqualTo(positions);
    }

    @Test
    void 해당_시점의_고득점자를_알_수_있다() {
        List<CarName> carNameList = List.of(new CarName("a"), new CarName("b"), new CarName("c"));
        Cars cars = new Cars(carNameList, new TestHelper.AlwaysMoveStrategy());
        Race race = new Race(cars);
        assertThat(race.getWinners().stream().map(CarResult::getCarName).toArray()).contains("a", "b", "c");
    }

    private static Stream<Arguments> oneLapTestStubs() {
        return Stream.of(
                Arguments.arguments(new TestHelper.AlwaysMoveStrategy(), List.of(1, 1, 1)),
                Arguments.arguments(new TestHelper.NeverMoveStrategy(), List.of(0, 0, 0))
        );
    }
}
