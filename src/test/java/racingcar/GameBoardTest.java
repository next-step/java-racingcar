package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameBoardTest {

    @Test
    void GameBoardTest_winnerTest() {
        GameBoard gameBoard = new GameBoard(List.of("pobi", "honux"), 5);
        Assertions.assertThat(gameBoard.getWinnerNames()).contains("pobi", "honux");
    }
}
