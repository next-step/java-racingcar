package racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @DisplayName("자동차 게임 시도 횟수 숫자만 입력 가능 여부 테스트")
    @Test
    void 자동차게임_시도횟수_입력값_숫자_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputGameCount("일"));
    }

    @DisplayName("자동차 게임 시도 음수 및 0 입력 불가 여부 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 자동차게임_시도횟수_입력값_음수_0_검증_테스트(String strings) {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputGameCount(strings));
    }

    @DisplayName("자동차 게임 시도 횟수 최대 10번 입력 가능 여부 테스트")
    @Test
    void 자동차게임_시도횟수_최대_입력값_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputGameCount("11"));
    }
}
