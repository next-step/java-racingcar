package carracing;

import carracing.domain.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void create() {
        assertThat(new Position(3)).isEqualTo(new Position(3));
    }

    @Test
    void invalid() {
        assertThatThrownBy(()->{
            new Position(-1);
        }).isInstanceOf(IllegalAccessException.class);

    }
}
