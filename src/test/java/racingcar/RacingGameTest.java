package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("Racing Game 은 시작되고 난후에 결과를 반환한다.")
    @Test
    void makeGame() {
        RacingGame racingGame = new RacingGame(5, 3);

        int[][] result = racingGame.run();

        assertThat(result[0][0]).isEqualTo(0);
    }
}