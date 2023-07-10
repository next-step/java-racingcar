package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.IllegalCountException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountTest {

    @DisplayName("시도 횟수 생성 성공 테스트")
    @Test
    void newCountTest() {
        assertDoesNotThrow(() -> new Count(1));
        assertDoesNotThrow(() -> new Count(0));
    }

    @DisplayName("음수를 받을 시 시도 횟수 생성 실패 테스트")
    @Test
    void newCountFailTest() {
        assertThrows(IllegalCountException.class, () -> new Count(-1));
    }
}
