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

    @DisplayName("음수 값 넣을시 Position 생성 실패")
    @Test
    void createPositionFailWhenNegativeValueTest() {
        assertThrows(IllegalPositionException.class, () -> new Position(-1));
    }

    @DisplayName("goForward value가 1 증가된 Position 반환하는지 테스트")
    @Test
    void goForwardTest() {
        Position position = new Position(1);
        position = position.goForward();
        assertThat(position).isEqualTo(new Position(2));
    }

    @DisplayName("isSamePosition value가 같을 시 true 반환 테스트")
    @Test
    void isSamePositionTrueTest() {
        assertThat(new Position(1).isSamePosition(1)).isTrue();
    }

    @DisplayName("isSamePosition value가 다를 시 false 반환 테스트")
    @Test
    void isSamePositionFalseTest() {
        assertThat(new Position(1).isSamePosition(2)).isFalse();
    }
}
