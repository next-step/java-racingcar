package racing;

import org.junit.jupiter.api.Test;
import racing.common.RacingManager;

public class RacingManagerTest {
    @Test
    void moveCarTest() {
        RacingManager manager = new RacingManager();
        manager.moveCars();
    }
}
