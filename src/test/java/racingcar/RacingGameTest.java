package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @DisplayName("자동차 경주 게임 실행 테스트")
    @Test
    void runRacingCarGame() {
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(condition);
        game.run();
        ResultView.printRacingGameLogs(game.getGameLogs());
    }
}