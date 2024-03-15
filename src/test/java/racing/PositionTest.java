package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(3);
    }

    @Test
    void isHighScore() {
        assertThat(position.isHighScore(3)).isTrue();
    }

    @Test
    void increase() {
        position.increase();
        assertThat(position.value()).isEqualTo(4);
    }
}
