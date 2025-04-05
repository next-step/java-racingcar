package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingManagerTest {

    @Test
    @DisplayName("자동차 개수와 시도 횟수가 0이거나 0보다 작을 때 예외를 던진다.")
    void car() {
        assertThrows(IllegalArgumentException.class, () -> new RacingManager("", 5));

        assertThrows(IllegalArgumentException.class, () -> new RacingManager("pobi", 0));

        assertThrows(IllegalArgumentException.class, () -> new RacingManager("", 0));
    }
}
