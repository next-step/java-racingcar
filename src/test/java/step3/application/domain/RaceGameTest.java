package step3.application.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.application.domain.factory.MovablePredicatedGenerator;
import step3.application.domain.model.dto.MovementLog;
import step3.application.domain.model.dto.OneMovementLog;
import step3.application.domain.model.dto.RaceGameLog;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RaceGameTest {

    public static Stream<Arguments> raceGameTestDataSet() {
        List<MovementLog> movementLogs = java.util.List.of(
                new MovementLog("pobi", 1),
                new MovementLog("crong", 1),
                new MovementLog("honux", 2)
        );
        return Stream.of(
                arguments(
                        java.util.List.of("pobi", "crong", "honux"),
                        java.util.List.of(1, 1, 2),
                        new RaceGameLog(
                                java.util.List.of(
                                        new OneMovementLog(movementLogs),
                                        new OneMovementLog(movementLogs),
                                        new OneMovementLog(movementLogs)
                                )
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("raceGameTestDataSet")
    void 차량들을_moveCount만큼_움직이려_시도한다(List<String> names, List<Integer> positions, RaceGameLog expected) {
        RaceGame raceGame = new RaceGame(names, positions);
        RaceGameLog result = raceGame.startRace(3, new MovablePredicatedGenerator());
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("raceGameTestDataSet")
    void 차량들에_대해_가장_멀리_움직인_인원을_조회한다(List<String> names, List<Integer> positions) {
        RaceGame raceGame = new RaceGame(names, positions);
        raceGame.startRace(3, new MovablePredicatedGenerator());
        List<String> best = raceGame.findBest(names);
        assertThat(best).hasSize(1).containsOnly("honux");
    }
}