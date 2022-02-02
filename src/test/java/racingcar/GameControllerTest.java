package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.movable.RandomMovableStrategy;

public class GameControllerTest {

    @DisplayName("GameController play() 테스트 - 예외 발생 없으면 정상 작동 검증")
    @Test
    void playSuccess() {
        assertDoesNotThrow(() -> new GameController("a,b,c", 5)
            .play(new RandomMovableStrategy()));
    }
}
