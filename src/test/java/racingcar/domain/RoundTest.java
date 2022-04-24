package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.RoundCount;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {


    @Test
    @DisplayName("total 라운드가 3인 경우 3라운드만 진행한다.")
    void roundCheck() {
        RoundCount totalRound = new RoundCount(3);
        Round round = new Round(totalRound);

        int tryCount = 0;
        while (round.isOngoing()) {
            round.nextRound();
            tryCount++;
        }

        assertThat(tryCount).isEqualTo(totalRound.toInt());
    }

}