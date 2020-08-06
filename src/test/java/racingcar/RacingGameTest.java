package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private static final int ZERO = 0;
    private RacingGame racingGame;

    @DisplayName("race 메소드 테스트")
    @Test
    void race_test() {
        int car = 3;
        int attempt = 5;

        racingGame = RacingGame.of(car, attempt);
        RacingResult racingResult = racingGame.race();

        assertThat(racingResult).isNotNull();
        assertThat(racingResult.getAttempt()).isEqualTo(attempt);
    }

    @DisplayName("isAvailableGame 메소드 true 반환하는 경우 테스트")
    @Test
    void isAvailableGame_true_test() {
        racingGame = RacingGame.of(3, 1);
        assertTrue(racingGame.isAvailableGame());

        racingGame = RacingGame.of(1000, 22);
        assertTrue(racingGame.isAvailableGame());
    }

    @DisplayName("isAvailableGame 메소드 false 반환하는 경우 테스트")
    @Test
    void isAvailableGame_false_test() {
        racingGame = RacingGame.of(ZERO, ZERO);
        assertFalse(racingGame.isAvailableGame());

        racingGame = RacingGame.of(2, ZERO);
        assertFalse(racingGame.isAvailableGame());

        racingGame = RacingGame.of(-1, 33);
        assertFalse(racingGame.isAvailableGame());
    }
}