package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @DisplayName("횟수와 자동차 대수를 입력받아 레이싱 게임을 생성한다.")
    @Test
    void create_racing_success() {
        // given
        int gameCount = 5;
        int carCount = 3;

        // when
        RacingGame racingGame = new RacingGame(5, 3);

        // then
        assertThat(racingGame.getGameCount()).isEqualTo(5);
        assertThat(racingGame.getCarCount()).isEqualTo(3);


    }

}
