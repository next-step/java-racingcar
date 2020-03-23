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

        assertThat(result[0][0]).isEqualTo(1);
        assertThat(result[1][0]).isEqualTo(2);
        assertThat(result[2][0]).isEqualTo(3);
        assertThat(result[3][0]).isEqualTo(4);
        assertThat(result[4][0]).isEqualTo(5);
    }
}