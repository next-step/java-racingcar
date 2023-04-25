package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {

    private final int numbOfTrial = 2;
    private RacingGame game;

    @BeforeEach
    void setUp() {
        game = new RacingGame(numbOfTrial,
                List.of("abc", "def"),
                new WinnerDecisionByBigLocations());
    }

    @Test
    void 시도횟수_만큼_게임을_진행하면_더이상_진행할수없다() {
        runGameUntilEnd();

        Assertions.assertThatExceptionOfType(GameEndedException.class)
                .isThrownBy(() -> game.runOnce());
    }

    private void runGameUntilEnd() {
        for (int i = 0; i < this.numbOfTrial; i++) {
            game.runOnce();
        }
    }

//    @Test
//    void 종료된_게임인지_알려준다() {
//        runGameUntilEnd();
//
//        Assertions.assertThat(game.isEnded()).isTrue();
//    }
//
//    @Test
//    void 게임_우승자를_알려준다() {
//        runGameUntilEnd();
//
//        Assertions.assertThat(game.winners()).contains();
//    }
}
