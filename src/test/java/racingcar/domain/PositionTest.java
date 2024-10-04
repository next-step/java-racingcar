package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    void isSamePosition_true() {
        Position position = new Position(5);
        assertThat(position.isSamePosition(5)).isTrue();
    }

    @Test
    void isSamePosition_false() {
        Position position = new Position(4);
        assertThat(position.isSamePosition(5)).isFalse();
    }

    @Test
    void add() {
        Position position = new Position(0);
        position.add();

        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    void max() {
        Position position = new Position(0);

        int max = position.max(5);

        assertThat(max).isEqualTo(5);
    }

}
