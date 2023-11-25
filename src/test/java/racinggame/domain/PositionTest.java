package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @DisplayName("위치를 음수로 입력 시 오류 발생 여부 테스트")
    @Test
    void 위치_음수_입력_불가_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }
}
