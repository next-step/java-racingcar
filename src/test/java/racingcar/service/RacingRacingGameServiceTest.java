package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.InputUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingRacingGaRmeServiceTest {

    @Test
    @DisplayName("입력한 값에 맞게 자동차가 생성되는지 확인")
    void check_car_numbers() {
        InputUtil.mockInputStream("3");

        RacingGameService game = new RacingGameService();
        game.setCarNumber();

        assertThat(game.getCarNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 값에 맞게 이동 횟수 저장하는지 확인")
    void check_car_move_times() {
        InputUtil.mockInputStream("3");

        RacingGameService game = new RacingGameService();
        game.setMoveTimes();

        assertThat(game.getMoveTimes()).isEqualTo(3);
    }

}