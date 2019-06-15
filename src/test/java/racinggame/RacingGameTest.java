package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    int round = 2;
    int car = 3;
    RacingGameParameters racingGameParameters = new RacingGameParameters(round, car);

    @Test
    void 생성자_정상() {
        RacingGame racingGame = new RacingGame(racingGameParameters);
        List<List<Integer>> actual = racingGame.getGameResult();

        Assertions.assertThat(actual).hasSize(1);
        Assertions.assertThat(actual.get(0)).hasSize(car);
        Assertions.assertThat(actual.get(0)).allMatch(integer -> integer == 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        RacingGame racingGame = new RacingGame(racingGameParameters);

        racingGame.playFullRound();

        List<List<Integer>> actual = racingGame.getGameResult();
        Assertions.assertThat(actual).hasSize(round + 1);
        Assertions.assertThat(actual.get(0)).allMatch(integer -> integer == 1);
        Assertions.assertThat(actual.get(1)).allMatch(integer -> integer == 2);
        Assertions.assertThat(actual.get(2)).allMatch(integer -> integer == 3);
    }
}
