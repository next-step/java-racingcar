package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @Test
    void checkFirstPosition() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkMovePosition(int moveCount) {
        Position position = new Position();
        for (int i = 1; i <= moveCount; i++) {
            position.move();
        }
        assertThat(position).isEqualTo(new Position(moveCount));
    }
}
