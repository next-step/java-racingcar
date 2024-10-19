package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    void 이동(){
        Position position = new Position(0);
        position.move();
        assertThat(position).isEqualTo(new Position(1));
        assertThat(position).isNotEqualTo(new Position(0));
    }
}
