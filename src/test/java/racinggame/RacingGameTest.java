package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {
    int round = 2;
    int car = 3;
    private RacingGameParameters racingGameParameters = new RacingGameParameters(round, car);

    @Test
    void 생성자_정상() {
        RacingGame racingGame = new RacingGame(racingGameParameters);
        List<GameResult> actual = racingGame.getGameResults().getGameResultList();

        Assertions.assertThat(actual).hasSize(1);
        Assertions.assertThat(actual.get(0).getGameResult()).hasSize(car);
        Assertions.assertThat(actual.get(0).getGameResult()).allMatch(integer -> integer == 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        RacingGame racingGame = new RacingGame(racingGameParameters);

        racingGame.playFullRound();

        // TODO: 랜덤때문에 테스트 깨짐
        List<GameResult> actual = racingGame.getGameResults().getGameResultList();
        Assertions.assertThat(actual).hasSize(round + 1);
        Assertions.assertThat(actual.get(0).getGameResult()).allMatch(integer -> integer == 1);
        Assertions.assertThat(actual.get(1).getGameResult()).allMatch(integer -> integer == 2);
        Assertions.assertThat(actual.get(2).getGameResult()).allMatch(integer -> integer == 3);
    }
}
