package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void racingGame_레이싱게임_종료() {
        RacingGame racingGame = new RacingGame("wu2ee,pobi,honux", new PositiveNumber(0));
        assertThat(racingGame.isRacingDone()).isTrue();
    }

    @Test
    void racingGame_레이싱게임_진행중() {
        RacingGame racingGame = new RacingGame("wu2ee,pobi,honux", new PositiveNumber(1));
        assertThat(racingGame.isRacingDone()).isFalse();
    }
}
