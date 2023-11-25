package racinggame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    @DisplayName("자동차이름 빈문자열 여부 테스트")
    @Test
    void 자동차게임_자동차이름_입력값_빈문자열_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName(null));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName(""));
    }

    @DisplayName("자동차이름 최소 1개의 쉼표(,) 포함 여부 테스트")
    @Test
    void 자동차게임_자동차이름_문자열_쉼표_포함_여부_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName("포르쉐A"));
    }

    @DisplayName("자동차이름 문자열에 쉼표(,,) 입력 확인 테스트")
    @Test
    void 자동차게임_자동차이름_문자열_연속쉼표_포함_여부_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName("포르쉐A,,,포르쉐B"));
    }

    @DisplayName("자동차이름 문자열 시작과 끝 쉼표 포함여부 확인 테스트")
    @Test
    void 자동차게임_자동차이름_문자열_시작끝_쉼표_포함_여부_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName(",포르쉐A,포르쉐B"));
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName("포르쉐A,포르쉐B,"));
    }

    @DisplayName("자동차이름 문자열에 쉼표 갯수가 9개까지 입력 가능여부 확인 테스트")
    @Test
    void 자동차게임_자동차이름_문자열_쉼표_갯수_제한_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> InputView.validateInputCarName("1,2,3,4,5,6,7,8,9,10,11"));
    }

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
