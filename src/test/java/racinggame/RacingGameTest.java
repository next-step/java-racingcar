package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    int round = 2;
    int car = 3;
    private RacingGameParameters racingGameParameters = new RacingGameParameters(round, car);

    @Test
    void 생성자_정상() {
        RacingGame racingGame = new RacingGame(racingGameParameters);
        List<GameResult> actual = racingGame.getGameResults().getGameResultList();

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getGameResult()).hasSize(car);
        assertThat(actual.get(0).getGameResult()).allMatch(integer -> integer == 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        RacingGame racingGame = new RacingGame(racingGameParameters);

        racingGame.playFullRound();

        List<GameResult> actual = racingGame.getGameResults().getGameResultList();
        assertThat(actual).hasSize(round + 1);
        assertThat(racingGameParameters.isFinished()).isTrue();
        // 이곳에서 게임 결과를 테스트 해야 할까요?
    }
}
