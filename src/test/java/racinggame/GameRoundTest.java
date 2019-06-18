package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameRoundTest {
    @Test
    void 게임이_진행중이면_isFinished_함수는_false_반환() {
        GameRound gameRound = new GameRound(2);

        assertThat(gameRound.isFinished()).isFalse();
    }

    @Test
    void 게임_라운드를_초과하면_isFinished_함수는_true_반환() {
        GameRound gameRound = new GameRound(2);

        gameRound.increaseCurrentRound();
        gameRound.increaseCurrentRound();

        assertThat(gameRound.isFinished()).isTrue();
    }

    @Test
    void 라운드가_끝났을때_increaseCurrentRound_호출시_에러() {
        GameRound gameRound = new GameRound(2);

        gameRound.increaseCurrentRound();
        gameRound.increaseCurrentRound();

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(gameRound::increaseCurrentRound);
    }
}
