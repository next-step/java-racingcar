package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {
    @Test
    @DisplayName("자동차의 대수는 0 이상이어야 한다.")
    void carNumTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(0));
    }

    @Test
    @DisplayName("자동차의 대수 만큼 자동차 위치 개수가 리턴되어야 한다.")
    void moveTest() {
        int carNum = 4;
        RacingGame racingGame = new RacingGame(carNum);
        assertThat(racingGame.move()).hasSize(carNum);
    }
}