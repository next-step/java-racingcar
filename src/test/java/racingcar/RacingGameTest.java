package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("게임을 진행할 때마다 자동차의 현재 위치를 리턴한다")
    public void moveCarsReturnsCurrentCarPosition() {
        RacingGame game = new RacingGame();

        assertThat(game.move()).containsExactly(1, 0, 1);
        assertThat(game.move()).containsExactly(2, 0, 2);
    }
}
