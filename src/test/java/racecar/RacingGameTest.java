package racecar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("4이상일 경우 true를 반환 하는지 확인")
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