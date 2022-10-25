import org.junit.jupiter.api.Test;
import racingCar.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    
    @Test
    void 전진() {
        assertThat(new Position(1).moveForward()).isEqualTo(new Position(2));
        assertThat(new Position(5).moveForward()).isEqualTo(new Position(6));
    }
}
