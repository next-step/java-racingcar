package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategies.CarMoveStrategy;
import racing.domain.strategies.CarMoveStrategyImpl;
import racing.domain.strategies.CustomRandomImpl;
import racing.service.RacingCarGame;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarGameTest {

    @DisplayName("자동차 이름을 입력하지 않으면 예외 발생")
    @Test
    void createGameThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(Collections.emptyList(), createMoveStrategy()));
    }

    private CarMoveStrategy createMoveStrategy() {
        return new CarMoveStrategyImpl(new CustomRandomImpl());
    }

    @DisplayName("이동횟수를 1 보다 작게 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void runThrowException(int numberOfMoves) {
        RacingCarGame game = new RacingCarGame(List.of("carA", "carB"), createMoveStrategy());
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> game.run(numberOfMoves));
    }

    @DisplayName("정상적으로 게임 실행 시 우승 자동차 1대 이상")
    @ParameterizedTest
    @ValueSource(ints= {1, 5})
    void testGameRun(int numberOfMoves) {
        List<String> names = List.of("carA", "carB");
        RacingCarGame racingCarGame = new RacingCarGame(names, createMoveStrategy());
        List<String> winner = racingCarGame.getWinner();
        assertThat(winner).hasSizeGreaterThan(0);
    }
}