package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    @Test
    void race() {
        RacingGame racingGame = new RacingGame("pobi,jason,woni", 5);
        racingGame.race();
        System.out.println(racingGame);
    }

    @Test
    void 게임_종료_후_실행() {
        RacingGame racingGame = new RacingGame("pobi,jason,woni", 1);
        racingGame.race();
        assertThatThrownBy(() -> {
            racingGame.race();
        }).isInstanceOf(IllegalStateException.class);
    }
}
