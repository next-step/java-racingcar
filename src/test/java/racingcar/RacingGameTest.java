package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @DisplayName("자동차 경주 게임 실행 테스트")
    @Test
    void runRacingCarGame() {
        RacingGameCondition condition = new RacingGameCondition(3, 5);
        RacingGame game = RacingGameFactory.make(condition);
        game.run();
        ResultView.printRacingGameLogs(game.getGameLogs());
    }
}
