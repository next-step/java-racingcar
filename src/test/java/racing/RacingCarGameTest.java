package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.CarMoveStrategy;
import racing.model.CarMoveStrategyImpl;
import racing.model.CustomRandomImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarGameTest {

    @DisplayName("자동차 수를 1대 보다 작게 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    void createGameThrowException(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(input, createMoveStrategy()));
    }

    private CarMoveStrategy createMoveStrategy() {
        return new CarMoveStrategyImpl(new CustomRandomImpl());
    }

    @DisplayName("이동횟수를 1 보다 작게 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    void runThrowException(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingCarGame(3, createMoveStrategy()).run(input));
    }

    @DisplayName("게임 실행 결과는 null 이 아니다")
    @Test
    void testGameRun() {
        RacingCarGame racingCarGame = new RacingCarGame(3, createMoveStrategy());
        GameResult gameResult = racingCarGame.run(5);
        assertThat(gameResult).isNotNull();
        assertThat(gameResult).isInstanceOf(GameResult.class);
    }
}