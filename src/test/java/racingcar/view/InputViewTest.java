package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void 입력값이_공백일때_예외처리_한다() {
        final String EMPTY = "";
        assertThatThrownBy(() -> InputView.validateTryCount(EMPTY))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 횟수는 공백일 수 없습니다.");
    }

    @Test
    void 횟수가_문자일때_예외처리_한다() {
        final String WORD = "one";
        assertThatThrownBy(() -> InputView.validateTryCount(WORD))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 횟수는 숫자만 허용합니다.");
    }

    @Test
    void 자동차_이름은_2개_이상이어야_한다() {
        final List<String> carNames = Arrays.asList("a");
        assertThatThrownBy(() -> InputView.validateCarNameCount(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 자동차 이름은 2개 이상이어야 합니다.");
    }
}