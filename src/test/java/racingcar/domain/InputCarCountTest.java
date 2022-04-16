package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.exception.InvalidNumberException;
import racingcar.domain.input.exception.OnlyPositiveException;

import static org.assertj.core.api.Assertions.*;

class InputCarCountTest {

    @Test
    @DisplayName("문자열이 공란인 경우 IllegalArgumentException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputBlankTest() {
        assertThatThrownBy(() -> new InputCarCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }

    @Test
    @DisplayName("문자열이 null 인 경우 IllegalArgumentException.class 예외(메시지 '최소 하나 이상의 이름을 입력해야합니다.')를 반환한다.")
    void inputNullTest() {
        assertThatThrownBy(() -> new InputCarCount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 하나 이상의 이름을 입력해야합니다.");
    }

}