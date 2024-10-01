package study.racing;

import org.junit.jupiter.api.Test;
import study.racing.car.Car;
import study.racing.ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void move() {
        Car racingCar = new Car("TEST");

        racingCar.move();

        assertThat(racingCar.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    void input_유효성_검사_자동차_2대미만() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.validateCar(new String[]{"a"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_유효성_검사_자동차_이름_5자_초과() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.validateCar(new String[]{"123456", "12345"});
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
