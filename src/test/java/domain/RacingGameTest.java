package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("이동하는 전략인 경우 n대의 자동차는 전진한다.")
    @ParameterizedTest
    @MethodSource("strategies")
    void test01(List<Car> cars, List<Position> positions) {
        // given
        RacingGame racingGame = new RacingGame(cars);

        // when
        racingGame.move();

        // then
        assertThat(cars.get(0).position()).isEqualTo(positions.get(0));
        assertThat(cars.get(1).position()).isEqualTo(positions.get(1));
    }

    public static Stream<Arguments> strategies() {
        return Stream.of(
                Arguments.of(List.of(new Car(3, () -> true), new Car(3, () -> true)), List.of(new Position(3), new Position(3))),
                Arguments.of(List.of(new Car(3, () -> false), new Car(3, () -> false)), List.of(new Position(0), new Position(0))),
                Arguments.of(List.of(new Car(3, () -> true), new Car(3, () -> false)), List.of(new Position(3), new Position(0)))
        );
    }
}
