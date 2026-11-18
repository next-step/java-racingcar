package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("주어진 대수만큼 자동차를 만든다")
    @Test
    void createsCars() {
        RacingGame game = new RacingGame(3, 5);
        assertThat(game.getCars()).hasSize(3);
    }
}
