package racinggamewinner;

import org.junit.jupiter.api.Test;
import racinggamewinner.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    public static final int DEFAULT_POSITION_NUMBER = 0;
    public static final int TEST_POSITION_NUMBER = 1;

    @Test
    void updatePosition_테스트() {
        Position position = new Position(DEFAULT_POSITION_NUMBER);
        position.updatePosition(TEST_POSITION_NUMBER);
        assertThat(position).isEqualTo(new Position(TEST_POSITION_NUMBER));
    }
}
