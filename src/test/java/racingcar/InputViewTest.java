package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("자동차 대수, 이동횟수 테스트")
    @Test
    void inputAndCarMakeTest() {
        InputView input = new InputView();
        assertThat(input.insertCar()).isEqualTo(3);
    }
}
