package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private int carAmount = 3;
    private int round = 2;
    private String carNameString;
    private RacingGameParameters racingGameParameters;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        carNameString = "pobi,crong,honux";
        MoveDecider moveDecider = new MoveDecider() {
            @Override
            public boolean canMove() {
                return true;
            }
        };
        racingGameParameters = new RacingGameParameters(round, carNameString, moveDecider);
        racingGame = new RacingGame(racingGameParameters);
    }

    @Test
    void 생성자_정상() {
        List<GameResult> actual = racingGame.getGameResults().getGameResults();

        assertThat(actual).hasSize(1);
        assertThat(actual.get(0).getGameResult()).hasSize(carAmount);
        assertThat(actual.get(0).getGameResult()).containsKeys("pobi", "crong", "honux");
        assertThat(actual.get(0).getGameResult()).containsValues(1, 1, 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        racingGame.playFullRound();

        List<GameResult> actual = racingGame.getGameResults().getGameResults();
        assertThat(actual).hasSize(round + 1);

        // TODO: 가능하다면 테스트를 구현해보자.
    }
}
