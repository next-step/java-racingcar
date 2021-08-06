package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void checkWordCount() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.checkWordCount("HELLOHELLO");
        }).isInstanceOf(WordCountException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
