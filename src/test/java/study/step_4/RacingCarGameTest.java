package study.step_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step_4.service.RacingCar;
import study.step_4.ui.InputView;
import study.step_4.ui.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    RacingCarGame racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCarGame(new InputView(), new OutputView());
    }

    @DisplayName("참여하는 자동차의 댓수 만큼 이를 List 에 생성하고 각 이름을 확인할 수 있다.")
    @Test
    void setUpRacingCar() {
        String[] input = {"포비", "뚜비", "나나"};
        List<RacingCar> racingCars = racingCar.setUpRacingCar(input);
        assertThat(racingCars.get(0).getName()).isEqualTo(input[0]);
        assertThat(racingCars.get(1).getName()).isEqualTo(input[1]);
        assertThat(racingCars.get(2).getName()).isEqualTo(input[2]);
    }
}