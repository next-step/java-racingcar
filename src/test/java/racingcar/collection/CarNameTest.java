package racingcar.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.NotEmptyCarNameException;
import racingcar.exception.TooLongCarNameException;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("CarName 객체 생성 시 이름이 5자를 넘을 경우 예외를 던진다.")
    public void 테스트_constructor_TooLongCarNameException() {

        assertThrows(TooLongCarNameException.class, () -> new CarName("123456"));
    }

    @Test
    @DisplayName("CarName 객체 생성 시 이름이 null이거나 빈 문자열일 경우 예외를 던진다.")
    public void 테스트_constructor_NotEmptyCarNameException() {

        assertThrows(NotEmptyCarNameException.class, () -> new CarName(""));
        assertThrows(NotEmptyCarNameException.class, () -> new CarName(null));
    }
}