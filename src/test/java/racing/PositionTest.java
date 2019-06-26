package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.model.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {


    Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    void getPosition() {
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    void progress() {
        position.progress();
        assertThat(this.position.getPosition()).isEqualTo(1);
    }
}