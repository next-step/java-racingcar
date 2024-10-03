package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("매치를 진행하면 match가 감소한다.")
    void 매치_카운트_감소() {
        RacingGame racingGame = new RacingGame(1, 5);
        racingGame.match();
        int matchCount = racingGame.getMatchCount();
        assertThat(matchCount).isEqualTo(4);
    }

    @Test
    @DisplayName("매치가 종료되면 false를 반환한다.")
    void 매치_종료() {
        RacingGame racingGame = new RacingGame(1, 0);
        assertThat(racingGame.isMatching()).isFalse();
    }

    @Test
    @DisplayName("매치가 진행중이면 true를 반환한다.")
    void 매치_진행() {
        RacingGame racingGame = new RacingGame(1, 5);
        assertThat(racingGame.isMatching()).isTrue();
    }
}
