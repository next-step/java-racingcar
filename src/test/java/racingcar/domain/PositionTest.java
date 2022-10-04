package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void 생성() {
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @Test
    void 음수_생성() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Position position = new Position();
        position.move();

        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void getPosition() {
        assertThat(new Position(2).getPosition()).isEqualTo(2);
    }

}
