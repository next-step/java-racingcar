package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    @DisplayName("위치 테스트")
    public void positionTest() {
        Position position1 = new Position(1);
        assertThat(position1.getValue()).isEqualTo(1);
    }
}
