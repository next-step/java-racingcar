package racingcar.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.game.GameBoard;

import java.util.List;

public class GameBoardTest {

    @Test
    void GameBoardTest_winnerTest() {
        List<String> carNames = List.of("pobi", "honux");
        int tryCount = 5;
        GameBoard gameBoard = new GameBoard(carNames);
        for (int i = 0; i < tryCount; i++) {
            gameBoard.run();
        }
        String[] winners = gameBoard.getWinnerNames().toArray(new String[0]);
        Assertions.assertThat(carNames).contains(winners);
    }
}
