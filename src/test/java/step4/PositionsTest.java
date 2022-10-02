package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PositionsTest {
    Positions positions;

    @BeforeEach
    void init() {
        positions = new Positions();
        positions.initPositions(3);
    }
    @Test
    void initPositionsTest() {

        List<Integer> positionsList = positions.getPositions();

        assertThat(positionsList.size()).isEqualTo(3);
        assertThat(positionsList.get(0)).isEqualTo(0);
    }

    @Test
    void moveTest() {
        positions.move(0);

        assertThat(positions.getPositions().get(0)).isEqualTo(1);
    }
}
