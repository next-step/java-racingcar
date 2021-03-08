package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private InputView inputView = new InputView();

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void carNameCanUnder5() {
        String[] carNames = {"jhLim97"};
        assertThat(inputView.isInValidNames(carNames)).isEqualTo(true);
    }
}