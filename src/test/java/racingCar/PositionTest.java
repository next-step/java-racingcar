package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingCar.domain.Position;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void 이동거리만들기() {
        Position position = new Position(3);
        assertThat(position.makePosition()).isEqualTo("---");
    }

    @Test
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 큰값비교하기() {
        assertThat(new Position(4).isBigCurrentPosition(new Position(3))).isTrue();
    }
}
