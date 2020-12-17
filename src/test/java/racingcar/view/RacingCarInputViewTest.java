package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarInputViewTest {
    @Test
    @DisplayName("자동차 대수 입력")
    void inputCarTotal() {
        RacingCarInputView.getCars();
    }

    @Test
    @DisplayName("시도할 횟수 입력")
    void intputTryCount() {
        RacingCarInputView.getCount();
    }

}
