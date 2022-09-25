package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("4 이상일 경우, 자동차가 전진한 결과를 반환해야 한다.")
    @Test
    void run_givenGreaterThanOrEqualTo4() {
        RacingGame game = new RacingGame(new ConstantNumberGenerator(4), 1, 3);
        int[][] result = game.run();
        assertThat(result[0][0]).isEqualTo(1);
        assertThat(result[1][0]).isEqualTo(2);
        assertThat(result[2][0]).isEqualTo(3);
    }

    @DisplayName("3 보다 작을 경우, 자동차가 정지한 결과를 반환해야 한다.")
    @Test
    void run_givenLessThan3() {
        RacingGame game = new RacingGame(new ConstantNumberGenerator(3), 1, 3);
        int[][] result = game.run();
        assertThat(result[0][0]).isEqualTo(0);
        assertThat(result[1][0]).isEqualTo(0);
        assertThat(result[2][0]).isEqualTo(0);
    }

}
