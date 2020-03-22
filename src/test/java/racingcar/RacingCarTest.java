package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCar;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void startTest() {
        //given
        InputView inputView = new InputView("Mark,Jaehyun,Johnny", "7");

        //when
        RacingCar racingCar = new RacingCar(inputView);
        racingCar.start();

        //then
        assertThat(racingCar.getCars()).hasSize(3);
        assertThat(racingCar.getResults()).hasSize(7);
        assertThat(racingCar.getWinners().size()).isGreaterThanOrEqualTo(1);
    }
}
