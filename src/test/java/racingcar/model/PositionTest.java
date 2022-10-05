package racingcar.model;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    List<Position> positions;

    @BeforeEach
    void setUp() {
        positions = new ArrayList<>();
        positions.add(new Position(1));
        positions.add(new Position(2));
        positions.add(new Position(3));
    }

    @Test
    void moveForward() {
        Position position = new Position();

        position.moveForward();

        assertThat(position.getValue()).isEqualTo(1);
    }

    @Test
    void negative_value() {
        ThrowingCallable actual = () -> new Position(-1);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage("0 미만의 수는 Position이 될 수 없습니다.");
    }
}