package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GameRoundTest {

    @ParameterizedTest
    @DisplayName("게임 종료 확인")
    @MethodSource
    void isGameEnd(int roundNum, boolean gameEnd) {
        GameRound gameRound = new GameRound(roundNum);

        assertThat(gameRound.isGameEnd()).isEqualTo(gameEnd);
    }

    static Stream<Arguments> isGameEnd() {
        return Stream.of(
                arguments(0, true),
                arguments(1, false)
        );
    }
}
