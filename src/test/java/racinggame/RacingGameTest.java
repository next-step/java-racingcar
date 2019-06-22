package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        GameResults actual = racingGame.getGameResults();

        assertThat(actual.getSize()).isEqualTo(1);
        assertThat(actual.getByIndex(0).getGameResult()).hasSize(carAmount);
        assertThat(actual.getByIndex(0).getGameResult()).containsKeys("pobi", "crong", "honux");
        assertThat(actual.getByIndex(0).getGameResult()).containsValues(1, 1, 1);
    }

    @Test
    void 게임_라운드_전체_진행() {
        racingGame.playFullRound();

        GameResults actual = racingGame.getGameResults();

        // 최초 위치도 GameResult 로 갖고 있어서 + 1 로 검사함.
        assertThat(actual.getSize()).isEqualTo(round + 1);
        assertThat(actual.getByIndex(round).getGameResult()).hasSize(carAmount);
        assertThat(actual.getByIndex(round).getGameResult()).containsKeys("pobi", "crong", "honux");
        assertThat(actual.getByIndex(round).getGameResult()).containsValues(round + 1, round + 1, round + 1);
    }
}
