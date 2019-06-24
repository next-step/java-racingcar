package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameRoundTest {
    private GameRound gameRound;

    @BeforeEach
    void setUp() {
        gameRound = new GameRound(2);
    }

    @Test
    void 게임이_진행중이면_isFinished_함수는_false_반환() {
        assertThat(gameRound.isFinished()).isFalse();
    }

    @Test
    void 게임_라운드를_초과하면_isFinished_함수는_true_반환() {
        gameRound = gameRound.nextRound();
        gameRound = gameRound.nextRound();

        assertThat(gameRound.isFinished()).isTrue();
    }

    @Test
    void 라운드가_끝났을때_increaseCurrentRound_호출시_에러() {
        gameRound = gameRound.nextRound();
        gameRound = gameRound.nextRound();

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(gameRound::nextRound);
    }
}
