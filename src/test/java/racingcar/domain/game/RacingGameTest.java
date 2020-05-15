package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarMoveResult;
import racingcar.domain.car.strategy.FixedMovementStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @DisplayName("getGameResult는 startGame을 하고나서 게임결과를 반환한다.")
    @Test
    void getGameResult() {
        GameInfo gameInfo = new GameInfo("pobi,crong,horox", 2);
        RacingGame racingGame = new RacingGame(gameInfo);
        racingGame.startGame(new FixedMovementStrategy());

        GameResult gameResult = racingGame.createGameResult();
        assertThat(gameResult).isEqualToComparingFieldByFieldRecursively(expectedGameResult());
    }

    private GameResult expectedGameResult() {
        String[] names = new String[]{"pobi", "crong", "horox"};

        PhaseResult firstPhaseResult = makePhaseResult(names, new int[]{1, 0, 1});
        PhaseResult secondPhaseResult = makePhaseResult(names, new int[]{1, 1, 1});

        List<PhaseResult> phaseResults = Arrays.asList(firstPhaseResult, secondPhaseResult);

        return new GameResult(2, phaseResults);
    }

    private PhaseResult makePhaseResult(String[] names, int[] locations) {
        List<CarMoveResult> carMoveResults = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            carMoveResults.add(new CarMoveResult(names[i], locations[i]));
        }

        return new PhaseResult(carMoveResults);
    }
}
