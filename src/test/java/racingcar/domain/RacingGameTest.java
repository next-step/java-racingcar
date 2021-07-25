package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rules.MoveRule;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RacingGameTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertDoesNotThrow(() -> new RacingGame(Collections.singletonList("pobi"), new MoveRule()));
    }
}