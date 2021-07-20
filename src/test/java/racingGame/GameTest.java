package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("자동차 수와 반복횟수를 매개변수로 게임 생성")
    void create() {
        Game game = new Game(3, 5);
        assertThat(game.getCarSize()).isEqualTo(3);
        assertThat(game.getRepeatCount()).isEqualTo(5);
    }
}
