package step3.racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingCar.view.InputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("음수를 입력받을 경우 exception")
    void negative() {
        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));
        assertThatThrownBy(InputView::numOfCars).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(InputView::times).isInstanceOf(RuntimeException.class);
    }
}
