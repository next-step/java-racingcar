package racingcar.domain.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.InvalidNumberException;
import racingcar.domain.exception.OnlyPositiveException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundCountTest {

    @Test
    @DisplayName("숫자 외 다른 값으로 생성할 경우 InvalidNumberException.class 예외(메시지 '숫자만 입력이 가능합니다.')를 반환한다.")
    void catTest() {
        assertThatThrownBy(() -> new RoundCount("string"))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage("숫자만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("음수 문자열값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberOnlyPositive() {
        assertThatThrownBy(() -> new RoundCount("-1"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("0 값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberNotZero() {
        assertThatThrownBy(() -> new RoundCount("0"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }
}