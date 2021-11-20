package carracing;

import carracing.util.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("위치 값 변경 테스트")
    void upPosition() {
        Position position = new Position();
        position.move();

        Assertions.assertThat(position.getPosition()).isEqualTo(1);
    }
}
