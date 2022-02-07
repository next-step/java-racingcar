package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 전체_게임기록_저장개수_테스트() {
        RacingGame racingGame = new RacingGame(new String[]{"a", "b", "c"}, 2);
        racingGame.race();
        Assertions.assertThat(racingGame.getRoundHistories().getAllRoundHistory().size()).isEqualTo(2);
    }
}
