package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("자동차 게임 승자 확인 - 1명 이상 존재")
    @Test
    void runRacingCarGame_singleWinner() {
        // given
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 10;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(condition);

        // when
        game.run();

        // then
        assertThat(game.getWinners()).hasSizeGreaterThan(0);
    }
}