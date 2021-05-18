package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ActionCarTest {

    @DisplayName("랜덤값을 추출한다")
    @Test
    void makeRandomNumber() {
        ActionCar actionCar = new ActionCar();
        int randomNumber = actionCar.random();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0);
        assertThat(randomNumber).isLessThan(10);
    }

    @DisplayName("자동차가 전진한다.")
    @Test
    void actionCar() {
        ActionCar actionCar = new ActionCar();
        int run = actionCar.run(7);
        assertThat(run).isEqualTo(1);
    }

    @DisplayName("자동차가 정지되어있다.")
    @Test
    void noActionCar() {
        ActionCar actionCar = new ActionCar();
        int stop = actionCar.run(2);
        assertThat(stop).isEqualTo(0);
    }

}