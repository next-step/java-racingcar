package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoundTest {

    @DisplayName("주어진 시도 횟수만큼 반복한 후 True를 반환한다.")
    @Test
    public void isEndRound_ShouldReturnTrue() {
        int inputTriesCount = 5;

        Round round = new Round(inputTriesCount);

        for (int i = 0; i < 5; i++) {
            round.reduceRound();
        }

        assertThat(round.isRoundContinue()).isTrue();
    }

    @DisplayName("주어진 시도 횟수만큼 반복한 후 True를 반환한다.")
    @Test
    public void isEndRound_ShouldReturnTrue1() {
        int inputTriesCount = 5;

        Round round = new Round(inputTriesCount);

        assertThat(round.isRoundContinue()).isTrue();
    }

}
