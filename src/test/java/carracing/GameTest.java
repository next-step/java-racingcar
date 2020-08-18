package carracing;

import carracing.domain.Car;
import carracing.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("입력값 inputValid() Exception")
    void Game_inputValid_테스트() {
        assertThatThrownBy(() -> new Game(0, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Game(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("start 테스트")
    void stsrt_테스트() {
        Game game = new Game(3, 5);
        game.start();
    }
}
