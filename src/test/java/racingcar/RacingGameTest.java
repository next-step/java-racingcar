package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("자동차 수가 1 미만이면 IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"5, 0", "10, 0", "100, 0"})
    void readyGame_CarCountLessThan0_Then_IllegalArgumentException(int time, int carCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(time, carCount));
    }

    @DisplayName("이동 횟수가 1 미만이면 IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({"0, 5", "0, 10", "0, 100"})
    void readyGame_timeLessThan0_Then_IllegalArgumentException(int time, int carCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(time, carCount));
    }

    @DisplayName("지정 횟수보다 많이 자동차를 이동시키면 IllegalStateException")
    @Test
    void move_timeIs0_Then_IllegalStateException() {
        int time = 1, carCount = 5;
        RacingGame game = new RacingGame(time, carCount);

        game.move();

        assertThatThrownBy(game::move)
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("자동차를 이동시키면 설정한 자동차 개수만큼의 위치 정보를 담은 목록을 리턴한다")
    @Test
    void readyGame() {
        int time = 5, carCount = 5;
        RacingGame game = new RacingGame(time, carCount);

        int[] positions = game.move();

        assertThat(positions.length).isEqualTo(time);
    }
}
