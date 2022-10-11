package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3_4.domain.Game;
import racingcar.step3_4.domain.GameAttribute;
import racingcar.step3_4.domain.GameRecord;

class GameTest {

    @DisplayName("자동차 경주 게임 실행")
    @Test
    void play() {
        GameAttribute gameAttribute = new GameAttribute(List.of("pobi", "crong", "honux"), 5);
        Game game = new Game(() -> 4);

        GameRecord result = game.play(gameAttribute);

        assertThat(result.getTryResults()).hasSize(5);
        assertThat(result.getWinners().getNames()).hasSize(3);
    }
}
