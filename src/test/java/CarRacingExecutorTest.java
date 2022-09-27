import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingExecutorTest {

    @Test
    void useRemainCountTest() {
        int expected = 1;

        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(5, 2);

        assertThat(carRacingExecutor.useRemainCount()).isEqualTo(true);
        assertThat(carRacingExecutor.getRemainMoveCount()).isEqualTo(expected);
    }
}
