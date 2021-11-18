package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    private final Position position = new Position(3);

    @Test
    void create() {
        assertThat(position).isEqualTo(new Position(3));
        assertThat(Position.ZERO).isEqualTo(new Position(0));
    }

    @Test
    void createFail() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }

    @Test
    void move() {
        assertThat(position.move()).isEqualTo(new Position(4));
    }

    @Test
    void findBigger() {
        assertThat(position.findBigger(new Position(2))).isEqualTo(new Position(3));
        assertThat(position.findBigger(new Position(3))).isEqualTo(new Position(3));
        assertThat(position.findBigger(new Position(4))).isEqualTo(new Position(4));
    }

}
