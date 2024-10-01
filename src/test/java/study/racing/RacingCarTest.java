package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.car.RacingCar;
import study.racing.ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void move() {
        RacingCar racingCar = new RacingCar();

        racingCar.move();

        assertThat(racingCar.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void input_유효성_검사_자동차_2대미만() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.validateCarCount(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_유효성_검사_게임_1개미만() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.validateGameCount(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
