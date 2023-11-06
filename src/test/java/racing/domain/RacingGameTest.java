package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("횟수와 자동차 대수를 입력받아 레이싱 게임을 생성한다.")
    @Test
    void create_racing_success() {
        // given
        int carCount = 5;
        int gameCount = 3;

        // when
        RacingGame racingGame = new RacingGame(carCount, gameCount);

        // then
        assertThat(racingGame.getCarCount()).isEqualTo(5);
        assertThat(racingGame.getGameCount()).isEqualTo(3);
    }
}
