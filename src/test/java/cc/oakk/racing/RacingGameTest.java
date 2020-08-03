package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    @Test
    @DisplayName("createRound 인자가 0 이하일 때 예외발생")
    public void createRound_ShouldThrow_IllegalArgumentException_OnBelowZero() {
        RacingGame racingGame = createDummyRacingGame();

        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(0, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(1, -5));
        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(-1, -5));
    }

    private RacingGame createDummyRacingGame() {
        return new RacingGame(new CarForwardCondition<>(c -> true, c -> c));
    }
}
