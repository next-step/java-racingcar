package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static race.MoveResult.MOVED;
import static race.MoveResult.STOPPED;

public class RaceTest {
    @ParameterizedTest(name = "{0}개의 자동차로 {1}번 경주를 진행하면 {2}에 따라 결과는 {3}이다.")
    @MethodSource("getRaceTestStubs")
    void 주어진_횟수_동안_여러_대의_자동차는_전진_또는_멈출_수_있다(int numOfCars, int laps, PowerGenerator powerGenerator, MoveResult expected) {
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(laps, cars);
        List<MoveResult> moveResultList = race.start()
                .getRaceResult()
                .stream()
                .flatMap(it -> it.getMoveResults().stream())
                .collect(Collectors.toList());

        assertThat(moveResultList.contains(expected == MOVED ? STOPPED : MOVED)).isFalse();
    }

    @ParameterizedTest(name = "레이스 결과를 통해 {1}번 경주를 진행했음을 알 수 있다.")
    @MethodSource("getRaceTestStubs")
    void 레이스_결과를_통해_이동_횟수를_알_수_있다(int numOfCars, int laps, PowerGenerator powerGenerator) {
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(laps, cars);
        RaceResult result = race.start();

        assertThat(result.getLaps()).isEqualTo(laps);
    }

    @ParameterizedTest(name = "레이스 결과를 통해 {0}대의 자동차가 경주를 진행했음을 알 수 있다.")
    @MethodSource("getRaceTestStubs")
    void 레이스_결과를_통해_자동차_수를_알_수_있다(int numOfCars, int laps, PowerGenerator powerGenerator) {
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(laps, cars);
        RaceResult result = race.start();

        assertThat(result.getNumOfCars()).isEqualTo(numOfCars);
    }

    @ParameterizedTest(name = "레이스 결과를 통해 {4}번째 순서에서 특정 자동차의 이동 여부를 알 수 있다")
    @MethodSource("getRaceTestStubs")
    void 레이스_결과를_통해_이동_여부를_알_수_있다(int numOfCars, int laps, PowerGenerator powerGenerator, MoveResult moveResult, int carNo, int lap) {
        Cars cars = new Cars(numOfCars, powerGenerator);
        Race race = new Race(laps, cars);
        RaceResult result = race.start();

        assertThat(result.getMoveResultOfCarAtLap(carNo, lap)).isEqualTo(moveResult);
    }

    private static Stream<Arguments> getRaceTestStubs() {
        return Stream.of(
                Arguments.arguments(3, 3, new TestHelper.BigPowerGenerator(), MOVED, 1, 1),
                Arguments.arguments(2, 4, new TestHelper.BigPowerGenerator(), MOVED, 1, 2),
                Arguments.arguments(3, 2, new TestHelper.SmallPowerGenerator(), STOPPED, 2, 1),
                Arguments.arguments(1, 1, new TestHelper.SmallPowerGenerator(), STOPPED, 0, 0)
        );
    }
}
