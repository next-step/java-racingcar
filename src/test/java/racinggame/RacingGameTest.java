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

        List<GameResult> actual = racingGame.getGameResults().getGameResultList();
        Assertions.assertThat(actual).hasSize(round + 1);
        Assertions.assertThat(racingGameParameters.isFinished()).isTrue();
        // 이곳에서 게임 결과를 테스트 해야 할까요?
    }
}
