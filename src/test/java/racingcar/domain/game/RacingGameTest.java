package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.FixedMovementStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @DisplayName("getGameResult는 startGame을 하고나서 게임결과를 반환한다.")
    @Test
    void getGameResult() {
        GameInfo gameInfo = new GameInfo(3, 2);
        RacingGame racingGame = new RacingGame(gameInfo);
        racingGame.startGame(new FixedMovementStrategy());

        GameResult gameResult = racingGame.getGameResult();
        assertThat(gameResult).isEqualToComparingFieldByFieldRecursively(expectedGameResult());
    }

    private GameResult expectedGameResult() {
        List<Integer> afterMove = Arrays.asList(1, 0, 1);
        List<Integer> afterMove2 = Arrays.asList(1, 1, 1);
        PhaseResult phaseResult = new PhaseResult(afterMove);
        PhaseResult phaseResult2 = new PhaseResult(afterMove2);
        List<PhaseResult> phaseResults = Arrays.asList(phaseResult, phaseResult2);
        return new GameResult(2, phaseResults);
    }
}
