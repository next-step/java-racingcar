package step5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차의_위치는_음수일_수_없다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 전진하면_위치값이_1커진다() {
        Position position = new Position();
        assertThat(position.move()).isEqualTo(new Position(1));
    }
}
