package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @Test
    void 이동() {
        position = new Position(0);
        position.move();
        assertThat(position).isEqualTo(new Position(1));
        assertThat(position).isNotEqualTo(new Position(0));
    }

    @Test
    void 비교() {
        position = new Position(3);
        assertThat(position.comparePosition(3)).isTrue();
    }

    @Test
    void 최댓값() {
        position = new Position(3);
        assertThat(position.getMaxPosition(4)).isEqualTo(4);
        assertThat(position.getMaxPosition(2)).isEqualTo(3);
    }


}
