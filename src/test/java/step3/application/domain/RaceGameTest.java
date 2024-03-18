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

    public static Stream<Arguments> move() {
        List<MovementLog> movementLogs = List.of(
                new MovementLog("pobi", 1),
                new MovementLog("crong", 1),
                new MovementLog("honux", 2)
        );
        return Stream.of(
                arguments(
                        List.of("pobi", "crong", "honux"),
                        List.of(1, 1, 2),
                        new RaceGameLog(
                                List.of(
                                        new OneMovementLog(movementLogs),
                                        new OneMovementLog(movementLogs),
                                        new OneMovementLog(movementLogs)
                                )
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("move")
    void moveCars(List<String> names, List<Integer> positions, RaceGameLog expected) {
        RaceGame raceGame = new RaceGame(names, positions);
        RaceGameLog result = raceGame.startRace(3, new MovablePredicatedGenerator());
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("move")
    void 최대값을_추출한다(List<String> names, List<Integer> positions) {
        RaceGame raceGame = new RaceGame(names, positions);
        raceGame.startRace(3, new MovablePredicatedGenerator());

        assertThat(raceGame.extractMaxPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("move")
    void 가장_멀리_움직인_인원을_조회한다(List<String> names, List<Integer> positions) {
        RaceGame raceGame = new RaceGame(names, positions);
        raceGame.startRace(3, new MovablePredicatedGenerator());
        int max = raceGame.extractMaxPosition();
        List<String> best = raceGame.findBest(max, names);
        assertThat(best).hasSize(1).containsOnly("honux");
    }
}