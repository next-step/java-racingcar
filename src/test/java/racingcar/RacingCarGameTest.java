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
}