package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundTest {

    @DisplayName("주어진 시도 횟수만큼 반복한 후 False를 반환한다.")
    @Test
    public void isRoundContinue_ShouldReturnFalse() {
        int inputTriesCount = 5;

        Round round = new Round(inputTriesCount);

        for (int i = 0; i < 5; i++) {
            round.reduceRound();
        }

        assertThat(round.isRoundContinue()).isFalse();
    }

}
