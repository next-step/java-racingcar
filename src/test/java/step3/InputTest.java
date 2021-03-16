package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputTest {

    // 입력 값 두 개를 한번에 테스트 넣어서 돌려 보고 싶은데...
    // @ValueSource(ints = {4, 5, 6, 7, 8}) 이런거 처럼.. 어떻게 해야 할 지..
    @DisplayName("입력 값이 음수이면 false 반환")
    @Test
    void inputIsMinusAndFalse() {
        assertFalse(InputView.isValidInput(3, -1));
    }

    @DisplayName("입력 값이 양수이면 true 반환")
    void inputIsPlusAndTrue() {
        assertTrue(InputView.isValidInput(3, 5));
    }
}
