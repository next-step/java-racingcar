package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("Random value가 0~9 사이의 값으로 생성된다.")
    public void randomValue_is_valid_whenBetweenZeroAndNine() {
        int actual = RacingGame.getRandomValue();
        assertThat(actual).isBetween(0, 9);
    }

}