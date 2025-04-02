import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Position;

class PositionTest {
    @Test
    @DisplayName("같은 값일 경우 같은 위치에 있는지를 확인")
    void comparePosition() {
        Position position1 = new Position(1);
        Position position2 = new Position(2);
        Position position3 = new Position(1);
        Assertions.assertAll(
            () -> assertEquals(position1, position3),
            () -> assertNotEquals(position1, position2),
            () -> assertThat(position1.compareTo(position2)).isEqualTo(-1),
            () -> assertThat(position1.compareTo(position3)).isEqualTo(0),
            () -> assertThat(position2.compareTo(position1)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("위치 프린트 테스트")
    void printPosition() {
        Position position1 = new Position(2);
        assertThat(position1.print()).isEqualTo("--");
    }
}