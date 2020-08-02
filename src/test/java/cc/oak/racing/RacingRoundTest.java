package cc.oak.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class RacingRoundTest {
    @Test
    @DisplayName("생성자의 totalRoundCount 인자가 0 미만일 때 예외발생")
    public void constructor_ShouldThrow_IllegalArgumentException_OnBelowZeroArgument() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingRound(new ArrayList<>(), -2));
    }

    @Test
    @DisplayName("nextRound를 최대 라운드 수 보다 넘게 호출 할 때 예외발생")
    public void nextRound_ShouldThrow_IndexOutOfBoundsException_OnBelowZero() {
        int totalRoundCount = 3;
        RacingRound racingRound = createDummyRacingRound(totalRoundCount);

        for (int i = 0; i < totalRoundCount; i++) {
            racingRound.nextRound();
        }

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(racingRound::nextRound);
    }

    private RacingRound createDummyRacingRound(int totalRoundCount) {
        return new RacingRound(new ArrayList<>(), totalRoundCount);
    }
}
