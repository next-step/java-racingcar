package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.strategies.CarMoveStrategy;
import racing.domain.strategies.CarMoveStrategyImpl;
import racing.domain.strategies.CustomRandomImpl;
import racing.dto.GameResult;
import racing.service.RacingCarGame;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarGameTest {

    @DisplayName("자동차 수를 1대 보다 작게 입력하면 예외 발생")
    @Test
    void createGameThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(Collections.emptyList(), createMoveStrategy()));
    }

    private CarMoveStrategy createMoveStrategy() {
        return new CarMoveStrategyImpl(new CustomRandomImpl());
    }

    @DisplayName("이동횟수를 1 보다 작게 입력하면 예외 발생")
    @Test
    void runThrowException() {
        List<String> names = List.of("carA", "carB");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(names, createMoveStrategy()).run(0));
    }

    @DisplayName("정상 입력하여 게임 실행 시 GameResult 객체가 반환된다")
    @ParameterizedTest
    @CsvSource(value = {"1,1", "3,5"})
    void testGameRun(int numberOfCars, int numberOfMoves) {
        List<String> names = List.of("carA", "carB");
        RacingCarGame racingCarGame = new RacingCarGame(names, createMoveStrategy());
        GameResult gameResult = racingCarGame.run(numberOfMoves);
        assertThat(gameResult).isInstanceOf(GameResult.class);
    }
}