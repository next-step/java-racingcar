package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.view.InputView;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("음수를 입력받을 경우 exception")
    void negative() {
        System.setIn(new ByteArrayInputStream("-1\n".getBytes()));
        assertThatThrownBy(InputView::times).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("구분자가 포함되지 않을 경우 exception")
    void separatorException() {
        System.setIn(new ByteArrayInputStream("yeo.jin.yu".getBytes()));
        assertThatThrownBy(InputView::nameOfCars).isInstanceOf(RuntimeException.class);
    }
}
