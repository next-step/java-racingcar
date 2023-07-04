package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    void GameBoardTest_winnerTest() {
        List<String> carNames = List.of("pobi", "honux");
        int tryCount = 5;
        Game game = new Game(carNames);
        for (int i = 0; i < tryCount; i++) {
            game.run();
        }
        String[] winners = game.getWinnerNames().toArray(new String[0]);
        Assertions.assertThat(carNames).contains(winners);
    }
}
