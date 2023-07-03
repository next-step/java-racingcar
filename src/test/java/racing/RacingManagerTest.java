package racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingManagerTest {
    @Test
    void isMovableTest() {
        //given
        RacingManager racingManager = new RacingManager();

        //when

        //then
        assertThat(racingManager.isMovable(0)).isEqualTo(false);
        assertThat(racingManager.isMovable(1)).isEqualTo(false);
        assertThat(racingManager.isMovable(2)).isEqualTo(false);
        assertThat(racingManager.isMovable(3)).isEqualTo(false);
        assertThat(racingManager.isMovable(4)).isEqualTo(true);
        assertThat(racingManager.isMovable(5)).isEqualTo(true);
        assertThat(racingManager.isMovable(6)).isEqualTo(true);
        assertThat(racingManager.isMovable(7)).isEqualTo(true);
        assertThat(racingManager.isMovable(8)).isEqualTo(true);
        assertThat(racingManager.isMovable(9)).isEqualTo(true);
    }
}
