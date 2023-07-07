package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.IllegalCarNameException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @DisplayName("자동차 이름 생성 성공 테스트")
    @Test
    void newCarNameTest() {
        assertDoesNotThrow(() -> new CarName("a"));
        assertDoesNotThrow(() -> new CarName("test1"));
    }

    @DisplayName("자동차 이름 생성 실패 테스트")
    @Test
    void newCarNameFailTest() {
        assertThrows(IllegalCarNameException.class, () -> new CarName(null));
        assertThrows(IllegalCarNameException.class, () -> new CarName(""));
        assertThrows(IllegalCarNameException.class, () -> new CarName("test12"));
    }


}
