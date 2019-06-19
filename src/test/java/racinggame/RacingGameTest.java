package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    int carAmount = 3;
    int round = 2;
    private String carNameString = "pobi,crong,honux";
    private RacingGameParameters racingGameParameters = new RacingGameParameters(round, carNameString);

    @Test
    void 생성자_정상() {
        RacingGame racingGame = new RacingGame(racingGameParameters);
        List<GameResult> actual = racingGame.getGameResults().getGameResults();

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getGameResult()).hasSize(carAmount);
        assertThat(actual.get(0).getGameResult()).allMatch(integer -> integer == 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        RacingGame racingGame = new RacingGame(racingGameParameters);

        racingGame.playFullRound();

        List<GameResult> actual = racingGame.getGameResults().getGameResults();
        assertThat(actual).hasSize(round + 1);

        // TODO: 가능하다면 테스트를 구현해보자.
    }
}
