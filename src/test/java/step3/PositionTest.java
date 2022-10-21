package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import step3.domain.Position;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 음수값입력() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
