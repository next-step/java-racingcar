package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    @DisplayName("같은 위치인지 확인한다")
    public void same_position() {
        int pos = 1;
        Position position = new Position(pos);

        assertThat(position.isSamePosition(pos)).isTrue();
    }

}
