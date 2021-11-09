package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.MovingStrategy.RandomMovingStrategy;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {


    @ParameterizedTest
    @DisplayName("주어진 횟수 만큼 Car는 이동, 정지 한다")
    @MethodSource
    void moveTryCount(Cars cars, TryCount count, int playCount, boolean expected) {
        RacingGame game = RacingGame.of(cars, count);

        IntStream.rangeClosed(1, playCount)
                .forEach(i -> game.play());

        assertThat(game.nonOver()).isEqualTo(expected);
    }

    static Stream<Arguments> moveTryCount() {
        return Stream.of(
                Arguments.of(
                        Cars.from(2, RandomMovingStrategy.getInstance()), TryCount.from(3), 2, Boolean.TRUE
                ),
                Arguments.of(
                        Cars.from(2, RandomMovingStrategy.getInstance()), TryCount.from(3), 4, Boolean.FALSE
                )
        );
    }

}