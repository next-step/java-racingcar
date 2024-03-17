package step3.application.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.application.domain.factory.MovablePredicatedGenerator;
import step3.application.domain.model.MovementLog;
import step3.application.domain.model.OneMoveRecord;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RacingCarsTest {

    public static Stream<Arguments> move() {
        return Stream.of(
                arguments(
                        List.of(
                                new Car("pobi", 1),
                                new Car("crong", 1),
                                new Car("honux", 2)
                        ),
                        new OneMoveRecord(List.of(
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
    void test(List<Car> cars, OneMoveRecord result) {
        RacingCars racingCars = new RacingCars(cars, generator);
        OneMoveRecord oneMoveRecord = racingCars.moveCars();
        assertThat(oneMoveRecord).isEqualTo(result);
    }
}