package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void 위치_생성_성공() {
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    void 위치_생성_실패() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치_이동() {
        Position position = new Position();
        position = position.nextPosition();
        assertThat(position).isEqualTo(new Position(1));
    }
}
