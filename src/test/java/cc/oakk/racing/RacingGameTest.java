package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    @Test
    @DisplayName("carName 인자의 크기가 0 이하일 때 예외발생")
    public void createRound_ShouldThrow_IllegalArgumentException_OnZeroSize() {
        RacingGame racingGame = createDummyRacingGame();
        List<String> dummyList = new ArrayList<>();

        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(dummyList, 5));
    }

    @Test
    @DisplayName("createRound 인자가 0 이하일 때 예외발생")
    public void createRound_ShouldThrow_IllegalArgumentException_OnBelowZero() {
        RacingGame racingGame = createDummyRacingGame();
        List<String> dummyList = Collections.singletonList("a");

        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(dummyList, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(dummyList, -1));
        assertThatIllegalArgumentException().isThrownBy(() -> racingGame.createRound(dummyList, -10));
    }

    private RacingGame createDummyRacingGame() {
        return new RacingGame(new CarForwardCondition<>(c -> true, c -> c));
    }
}
