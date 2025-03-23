import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingManagerTest {

    @Test
    @DisplayName("자동차 개수와 시도 횟수가 0보다 작을 때 예외를 던진다.")
    void car() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingManager(0, 5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new RacingManager(3, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new RacingManager(0, 0);
        });
    }
}
