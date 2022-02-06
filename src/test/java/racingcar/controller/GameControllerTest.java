package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.movable.RandomMovableStrategy;

public class GameControllerTest {
    @DisplayName("GameController에 ('a,b,c,d', 6)을 인자로 넣었을때, startGame 메서드가 정상 작동한다.")
    @Test
    void playSuccess() {
        assertDoesNotThrow(
            () -> new GameController("a,b,c,d", 6)
                .startGame(RandomMovableStrategy.getInstance())
        );
    }
}
