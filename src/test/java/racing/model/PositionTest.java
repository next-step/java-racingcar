package racing.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.IllegalPositionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @DisplayName("Position 생성 정상")
    @Test
    void createPositionTest() {
        assertDoesNotThrow(() -> new Position(0));
        assertDoesNotThrow(() -> new Position(1));
    }

    @DisplayName("Position 생성 실패")
    @Test
    void createPositionFailTest() {
        assertThrows(IllegalPositionException.class, () -> new Position(-1));
    }

    @DisplayName("goForward 테스트")
    @Test
    void goForwardTest() {
        Position position = new Position(1);
        position = position.goForward();
        assertThat(position).isEqualTo(new Position(2));
    }

    @DisplayName("isValue 테스트")
    @Test
    void isValueTest() {
        assertThat(new Position(1).isValue(1)).isTrue();
    }
}
