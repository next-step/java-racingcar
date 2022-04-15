package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.exception.InvalidNumberException;
import racingcar.domain.input.exception.OnlyPositiveException;

import static org.assertj.core.api.Assertions.*;

class InputCarCountTest {

    @Test
    @DisplayName("숫자 외 다른 값으로 생성할 경우 InvalidNumberException.class 예외(메시지 '숫자만 입력이 가능합니다.')를 반환한다.")
    void catTest() {
        assertThatThrownBy(() -> new InputCarCount("string"))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessage("숫자만 입력이 가능합니다.");
    }

    @Test
    @DisplayName("음수 문자열값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberOnlyPositive() {
        assertThatThrownBy(() -> new InputCarCount("-1"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("0 값으로 생성할 경우 OnlyPositiveException 에외(메시지 '1 이상의 값만 가능합니다.')를 반환한다.")
    void InputNumberNotZero() {
        assertThatThrownBy(() -> new InputCarCount("0"))
                .isInstanceOf(OnlyPositiveException.class)
                .hasMessage("1 이상의 값만 가능합니다.");
    }

    @Test
    @DisplayName("문자열 숫자를 입력하면 해당 숫자만큼의 List<Car> 를 반환한다.")
    void StringToInt() {
        assertThat(new InputCarCount("2").toCars().size()).isEqualTo(2);
    }
}