package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 입력값이_공백일때_예외처리_한다() {
        final String EMPTY = "";
        assertThatThrownBy(() -> InputView.validateTryCount(EMPTY))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 횟수는 공백일 수 없습니다.");
    }
}