package step3.application.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.application.domain.factory.MovablePredicatedGenerator;
import step3.application.domain.model.MovementLog;
import step3.application.domain.model.OneMovementLog;
import step3.application.domain.model.RaceGameLog;

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
                        List.of(
                                new Car("pobi", 1),
                                new Car("crong", 1),
                                new Car("honux", 2)
                        ),
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
    void moveCars(List<Car> cars, RaceGameLog expected) {
        RaceGame raceGame = new RaceGame(cars, new MovablePredicatedGenerator());
        RaceGameLog result = raceGame.startRace(3);
        assertThat(result).isEqualTo(expected);
    }
}