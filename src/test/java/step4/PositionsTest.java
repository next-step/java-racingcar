package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class PositionsTest {
    Position position;

    @BeforeEach
    void init() {
        position = new Position();
        position.initPosition(new ArrayList<>(List.of(new String[]{"test1", "test2"})));
    }
    @Test
    void initPositionsTest() {

        Map<String, Integer> positions = position.getPositions();

        assertThat(positions.size()).isEqualTo(3);
        assertThat(positions.get("test1")).isEqualTo(0);
    }

    @Test
    void moveTest() {
        position.move("test1");

        assertThat(position.getPositions().get("test1")).isEqualTo(1);
    }
}
