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

    @Test
    @DisplayName("그랑프리 리포트를 하면 현재 상황을 리턴한다.")
    void reportTest() {
        // given
        var luckyDice = new DiceTest.MockRandom(Car.MOVE_THRESHOLD + 1);
        var totalRound = 5;
        var carCount = 3;
        var grandPrix = new GrandPrix(totalRound, carCount, luckyDice);
        var playTimes = 3;

        for (int i = 0; i < playTimes; i++) {
            grandPrix.play();
        }

        // when
        var report = grandPrix.report();

        // then
        Assertions.assertThat(report).hasSize(carCount);
        Assertions.assertThat(report.values()).allMatch(it -> it == playTimes);
    }
}
