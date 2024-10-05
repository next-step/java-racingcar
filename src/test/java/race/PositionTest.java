package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 생성() {
        Position position = new Position(4);
        assertThat(position).isEqualTo(new Position(4));
    }
}
