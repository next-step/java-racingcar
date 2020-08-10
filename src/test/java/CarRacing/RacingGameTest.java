package CarRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    @DisplayName("랜덤값이 0~9사이에서 실행되는지 확인")
    void call_random_number() {
        assertThat(RacingGame.randomNumber()).isLessThan(10);
        assertThat(RacingGame.randomNumber()).isBetween(0, 10);
        assertThat(RacingGame.randomNumber()).isGreaterThan(0);
    }
}
