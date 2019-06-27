package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moving.DefaultMovingStrategy;
import racingcar.domain.moving.MockRandomValueProvider;
import racingcar.dto.GameRequest;
import racingcar.dto.GameResult;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("시도한 수만큼 게임결과를 저장하는지 확인한다")
    void checkSnapshop() {
        // given
        RacingGame racingGame = new RacingGame(new DefaultMovingStrategy(new MockRandomValueProvider(10)));
        GameRequest gameRequest = GameRequest.of(Arrays.asList("blue", "green", "yellow"), 5);
        // when
        GameResult gameResult = racingGame.start(gameRequest);
        // then
        assertThat(gameResult.getSnapshot().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자를 정상적으로 선출하는지 확인한다")
    void checkWinners() {
        // given
        RacingGame racingGame = new RacingGame(new DefaultMovingStrategy(new MockRandomValueProvider(10)));
        GameRequest gameRequest = GameRequest.of(Arrays.asList("blue", "green", "yellow"), 5);
        // when
        GameResult gameResult = racingGame.start(gameRequest);
        // then
        assertThat(gameResult.getWinnerNames()).isEqualTo("blue,green,yellow");
    }
}
