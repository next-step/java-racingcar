package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {
    @Test
    @DisplayName("한번 이동시 포지션값 +1")
    void move_test() {
        Position origin = new Position(1);
        Position result = origin.move();
        assertThat(result).isEqualTo(new Position(2));
    }
}
