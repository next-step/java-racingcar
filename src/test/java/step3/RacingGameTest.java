package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    void checkPass() {
        RacingGame racingGame = new RacingGame();
        boolean result = racingGame.checkPass(3);
        assertThat(result).isFalse();

        result = racingGame.checkPass(4);
        assertThat(result).isTrue();

        result = racingGame.checkPass(5);
        assertThat(result).isTrue();
    }
}