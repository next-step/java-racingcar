package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameLogStoreTest {

    @DisplayName("자동차 경주 로그 저장소 사이즈 확인")
    @Test
    void sizeLogs() {
        // given
        final int racingCarCount = 3;
        final int gameTurnCount = 5;
        RacingGameCondition condition = new RacingGameCondition(racingCarCount, gameTurnCount);
        RacingGame game = RacingGameFactory.make(condition);

        // when
        game.run();

        // then
        assertThat(game.getGameLogs()
                       .size()).isEqualTo(5);
    }
}
