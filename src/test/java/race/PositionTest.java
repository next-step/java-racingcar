package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 생성() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }

    @Test
    void Position은_음수가_아니다() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Position not allowed minus");
    }
}
