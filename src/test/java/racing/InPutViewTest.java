package racing;

import org.junit.jupiter.api.Test;
import racing.ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InPutViewTest {
    @Test
    void 자동차대수와회수입력() {
        InputView inputView = new InputView(3,7);
        assertThat(inputView.car_count).isEqualTo(3);
        assertThat(inputView.try_count).isEqualTo(7);
    }

    @Test
    void 음수입력시예외처리() {
        assertThatThrownBy(() -> new InputView(-3,7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
        assertThatThrownBy(() -> new InputView(3,-7)).isInstanceOf(IllegalArgumentException.class).hasMessage("음수는 입력할 수 없습니다.");
    }



}
