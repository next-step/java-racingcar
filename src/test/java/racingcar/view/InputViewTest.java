package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.InputUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    @DisplayName("자동차 대수를 입력한다")
    void input_car_number() {
        InputUtil.mockInputStream("3");

        InputView inputView = new InputView();
        assertThat(inputView.setCarNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이동 횟수를 입력한다")
    void input_car_move_times() {
        InputUtil.mockInputStream("3");

        InputView inputView = new InputView();
        assertThat(inputView.setMoveTimes()).isEqualTo(3);
    }
}
