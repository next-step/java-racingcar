package step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameHandlerTest {

    @Test
    void 게임_결과_테스트() {

        RacingGame racingGame = new RacingGame(3, 5);
        MoveStrategy strategy = new RandomMoveStrategy();
        RacingGameHandler handler = new RacingGameHandler(racingGame, strategy);

        List<List<Integer>> results = handler.playWithMoveStrategy();

        assertThat(results).hasSize(5);
        results.forEach(result -> assertThat(result).hasSize(3));
    }

}
