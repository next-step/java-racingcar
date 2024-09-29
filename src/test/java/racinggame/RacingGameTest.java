package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private final RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("게임을 시도할 회수만큼 게임 라운드가 증가한다.")
    void getGameRound(int tryCount) {
        racingGame.start(tryCount);
        assertThat(racingGame.getRound()).isEqualTo(tryCount);
    }

}
