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

    @DisplayName("null 전달 시 자동차 이름 생성 실패 테스트")
    @Test
    void newCarNameNullFailTest() {
        assertThrows(IllegalCarNameException.class, () -> new CarName(null));
    }

    @DisplayName("빈 문자열 전달 시 자동차 이름 생성 실패 테스트")
    @Test
    void newCarNameBlankFailTest() {
        assertThrows(IllegalCarNameException.class, () -> new CarName(""));
    }

    @DisplayName("5글자 초과 문자열 전달 시 자동차 이름 생성 실패 테스트")
    @Test
    void newCarNameLongStringFailTest() {
        assertThrows(IllegalCarNameException.class, () -> new CarName("test12"));
    }
}
