package step3.application.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.application.domain.factory.MovablePredicatedGenerator;
import step3.application.domain.model.dto.MovementLog;
import step3.application.domain.model.dto.OneMovementLog;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RacingCarsTest {

    public static Stream<Arguments> move() {
        return Stream.of(
                arguments(
                        List.of("pobi", "crong", "honux"),
                        List.of(1, 1, 2),
                        new OneMovementLog(List.of(
                                new MovementLog("pobi", 1),
                                new MovementLog("crong", 1),
                                new MovementLog("honux", 2)
                        ))
                )
        );
    }

    public final MovableGenerator generator = new MovablePredicatedGenerator();

    @ParameterizedTest
    @MethodSource("move")
    void 차량들에_대해_레이스를_진행한다(List<String> names, List<Integer> positions, OneMovementLog result) {
        RacingCars racingCars = new RacingCars(names, positions);
        OneMovementLog oneMovementLog = racingCars.doRace(generator);
        assertThat(oneMovementLog).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("move")
    void 차량들에_대해_이동거리를_비교하여_최대값을_추출한다(List<String> names, List<Integer> positions) {
        RacingCars racingCars = new RacingCars(names, positions);
        int result = racingCars.extractMaximumPosition();
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("move")
    void 차량들에_대해_가장_멀리_이동한_차량을를_조회한다(List<String> names, List<Integer> positions) {
        RacingCars racingCars = new RacingCars(names, positions);
        int max = racingCars.extractMaximumPosition();
        List<Car> bestDriver = racingCars.findBestDriver(max);
        assertThat(bestDriver)
                .hasSize(1)
                .containsOnly(new Car("honux", 2));
    }
}