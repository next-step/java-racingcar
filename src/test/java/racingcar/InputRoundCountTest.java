package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputRoundCountTest {

    @Test
    @DisplayName("숫자 외 다른 값으로 생성할 경우 NumberFormatException.class 예외(메시지 '숫자만 입력이 가능합니다.')를 반환한다.")
    void catTest() throws Exception {
        assertThatThrownBy(() -> new InputRoundCount("string"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("음수 문자열값으로 생성할 경우 IllegalArgumentException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberOnlyPositive() throws Exception {
        assertThatThrownBy(() -> new InputRoundCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("0 값으로 생성할 경우 IllegalArgumentException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberNotZero() throws Exception {
        assertThatThrownBy(() -> new InputRoundCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }
}