package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    @DisplayName("차 대수 입력받기")
    public void carInput() {
        int carNum = inputView.carInput();
        assertThat(carNum).isEqualTo(3);
    }

    @Test
    @DisplayName("실행 대수 입력받기")
    public void tryInput() {
        int tryNum = inputView.tryInput();
        assertThat(tryNum).isEqualTo(3);
    }
}
