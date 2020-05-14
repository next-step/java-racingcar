package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @DisplayName("자동차 대수와 이동 횟수가 0 보다 같거나 작으면 IllegalArgumentException 발생한다.")
    @Test
    void canNotCreateRacingGameIfLessThanZero() {
        assertThatThrownBy(() -> new RacingGame(0, 0, () -> true))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RacingGame(-1, -1, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 대수와 이동 횟수가 0보다 크면 정상적으로 생성할 수 있다.")
    @Test
    void canCreateRacingGameIfGreaterThanZero() {
        assertThat(new RacingGame(1, 1, () -> true)).isNotNull();
    }

    @DisplayName("자동차 경주가 정상 실행 되면 자동차 이동결과를 얻을 수 있다.")
    @Test
    void canGetResultCarPositionsForRacingGame() {
        RacingGame racingGame = new RacingGame(3, 5, new RandomMovableStrategy());
        racingGame.start();
        assertThat(racingGame.getResultCarPositions()).isNotNull();
    }
}
