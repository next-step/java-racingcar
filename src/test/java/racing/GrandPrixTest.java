package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GrandPrixTest {

    @Test
    @DisplayName("전체 라운드 수를 입력받아 전체 라운드 수 만큼 play한다")
    void playForTotalRoundCountTest() {
        // given
        int totalRound = 5;
        var grandPrix = new GrandPrix(totalRound);
        int playedRound = 0;

        // when
        while (!grandPrix.isFinished()) {
            grandPrix.play();
            playedRound++;
        }

        // then
        Assertions.assertThat(grandPrix.isFinished()).isTrue();
        Assertions.assertThat(playedRound).isEqualTo(totalRound);
    }
}
