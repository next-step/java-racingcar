package carracing;

import carracing.domain.Car;
import carracing.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    @Test
    @DisplayName("입력값 inputValid() Exception")
    void Game_inputValid_테스트() {
        assertThatThrownBy(() -> new Game("", 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Game("car1", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3/3"}, delimiter = '/')
    @DisplayName("start 테스트")
    void stsrt_테스트(String carNames, int tryCount) {
        Game game = new Game(carNames, tryCount);
        game.start();
    }
}
