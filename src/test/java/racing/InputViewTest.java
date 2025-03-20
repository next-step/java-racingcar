package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void testTooLongCarNameLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.splitAndValidate("123456");
        });
    }

    @Test
    @DisplayName("자동차 이름은 1글자 이상, 5글자 이하 정상이다.")
    void testValidCarNameLength() {
        String[] carNames = InputView.splitAndValidate("1,12,123,1234,12345");
        assertArrayEquals(new String[]{"1","12","123","1234","12345"}, carNames);
    }

    @Test
    @DisplayName("자동차 이름은 쉼포를 기준으로 구분한다.")
    void testCarNameSplit() {
        String[] carNames = InputView.splitAndValidate("pobi,crong,honux");
        assertArrayEquals(new String[]{"pobi", "crong", "honux"}, carNames);
    }
}