package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class GrandPrixTest {

    @Test
    @DisplayName("전체 라운드 수를 입력받아 전체 라운드 수 만큼 play한다")
    void playForTotalRoundCountTest() {
        // given
        int totalRound = 5;
        var grandPrix = new GrandPrix(totalRound, 0, new Random());

        // when
        while (!grandPrix.isFinished()) {
            grandPrix.play();
        }

        // then
        Assertions.assertThat(grandPrix.isFinished()).isTrue();
    }
}
