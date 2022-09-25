package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    public void 입력값_테스트() {
        RacingCar racingCarInput = InputView.getRacingCarInput();
        Assertions.assertThat(racingCarInput).isEqualTo(new RacingCar(3, 5));
    }
}