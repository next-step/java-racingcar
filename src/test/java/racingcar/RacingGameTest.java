package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.RacingGame;
import racingcar.view.InputResult;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest(name = "({0}, {1})의 input을 받으면 {0}대의 차, {1}번 시도하는 게임이 생성되어야 한다")
    @MethodSource("racingGameInputs")
    void testPlay_given_3_cars_5_rounds(int numberOfCars, int numberOfTries) {
        // Given & When
        RacingGame racingGame = new RacingGame(new InputResult(numberOfCars, numberOfTries));

        // Then
        assertThat(racingGame.getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(racingGame.getLastRound()).isEqualTo(numberOfTries);
    }

    static Stream<Arguments> racingGameInputs() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4),
                Arguments.of(5, 6)
        );
    }
}