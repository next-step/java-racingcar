package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameTest {

    @DisplayName("자동차 경주 게임 실행 테스트")
    @Test
    void runRacingGame() {
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);
        game.run();
        ResultView.printRacingGameLogs(game.getGameLogs());
    }

    @DisplayName("자동차 경주 게임 - 항상 이동 테스트")
    @Test
    void runRacingGame_allDraw() {
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(() -> true, condition);
        game.run();
        assertTrue(game.getWinners()
                       .stream()
                       .allMatch(racingCar -> racingCar.getDistance() == 5));
    }

    @DisplayName("자동차 경주 게임 - 제자리 테스트")
    @Test
    void runRacingGame_allAround() {
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 5;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(() -> false, condition);
        game.run();
        assertTrue(game.getWinners()
                       .stream()
                       .allMatch(racingCar -> racingCar.getDistance() == 0));
    }

    @DisplayName("자동차 게임 승자 확인 - 1명 이상 존재")
    @Test
    void runRacingGame_singleWinner() {
        // given
        final String racingCarNames = "woody,beans,isla";
        final int gameTurnCount = 10;

        RacingGameCondition condition = new RacingGameCondition(racingCarNames, gameTurnCount);
        RacingGame game = RacingGameFactory.make(new RandomMovingStrategy(), condition);

        // when
        game.run();

        // then
        assertThat(game.getWinners()).hasSizeGreaterThan(0);
    }
}