package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.RandomlyMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingGameResultTest {

    @DisplayName("우승자는 최소한 한 명 이상")
    @Test
    public void whoAreWinnersTest() {
        RacingCarNames racingCarNames = new RacingCarNames("more", "much", "less");
        RacingGame racingGame = new RacingGame(racingCarNames, 5, new RandomlyMove(10, 4));
        RacingGameResult racingGameResult = racingGame.gameStart();

        List<String> winners = racingGameResult.whoAreWinners();
        Assertions.assertThat(winners).hasSizeGreaterThan(0);
    }

    @DisplayName("모두가 공동 우승")
    @Test
    public void allAreWinnersTest() {
        RacingCarNames racingCarNames = new RacingCarNames("more", "much", "less");
        RacingGame racingGame = new RacingGame(racingCarNames, 5, new AlwaysMove());
        RacingGameResult racingGameResult = racingGame.gameStart();

        List<String> winners = racingGameResult.whoAreWinners();
        Assertions.assertThat(winners).hasSize(racingCarNames.length());
    }
}
