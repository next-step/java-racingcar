package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 음수_이동_테스트() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 크기_비교_테스트() {
        Position position = new Position(1);
        Position position2 = new Position(2);
        assertThat(position.isBiggerThan(position2)).isFalse();
    }

    @Test
    void 이동_테스트() {
        Position position = new Position(0);
        assertThat(position.move()).isEqualTo(new Position(1));
    }

}
