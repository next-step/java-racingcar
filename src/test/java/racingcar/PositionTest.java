package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void createPositionDefaultShouldBe1() {
        Position p = new Position();
        assertThat(p).isEqualTo(new Position(1));
    }

    @Test
    void invalidArgs() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void handleStringArgs() {
        assertThat(new Position("1")).isEqualTo(new Position(1));
    }
}

