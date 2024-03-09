package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("racingGameProvider")
    void racingGame(String title, List<Car> actualCarList, List<Car> expectedCarList) {
        RacingGame actual = new RacingGame(actualCarList);
        actual.run(1);

        RacingGame expected = new RacingGame(expectedCarList);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> racingGameProvider() {
        final MoveStrategy trueMoveStrategy = () -> true;
        final MoveStrategy falseMoveStrategy = () -> false;
        return Stream.of(
                Arguments.arguments(
                        "이동 전략이 true일때 자동차 위치는 1씩 증가한다",
                        Arrays.asList(new Car(1, trueMoveStrategy), new Car(2, trueMoveStrategy), new Car(3, trueMoveStrategy)),
                        Arrays.asList(new Car(2, trueMoveStrategy), new Car(3, trueMoveStrategy), new Car(4, trueMoveStrategy))),
                Arguments.arguments(
                        "이동 전략이 false일때 자동차는 현 위치를 유지한다",
                        Arrays.asList(new Car(1, falseMoveStrategy), new Car(2, falseMoveStrategy), new Car(3, falseMoveStrategy)),
                        Arrays.asList(new Car(1, falseMoveStrategy), new Car(2, falseMoveStrategy), new Car(3, falseMoveStrategy))
                )
        );
    }

}
