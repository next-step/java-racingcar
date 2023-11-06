package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    @DisplayName("게임 상태 관리 - 자동차 수, 시도 회수를 저장한다")
    void racing_car_count() {
        RacingCarGame racingCarGame = new RacingCarGame(5, 10);

        assertThat(racingCarGame.carCount()).isEqualTo(5);
        assertThat(racingCarGame.attemptCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("자동차 새성 - 입력한 수만큼 자동차를 생성한다.")
    void create_car_and_count() {
        RacingCarGame racingCarGame = new RacingCarGame(5, 10);
        racingCarGame.createCar();

        assertThat(racingCarGame.carList().size()).isEqualTo(5);
    }
}