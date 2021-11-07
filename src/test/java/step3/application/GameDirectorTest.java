package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.board.GameBoard;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameDirectorTest {

    private static final int FIRST_ROW_INDEX = 0;

    @DisplayName("n대의 자동차가 각각 주어진 횟수 만큼 정지 or 전진 하는지 테스트")
    @Test
    void playGameTest() {
        //given
        GameBoard gameBoard = new GameBoard();
        GameDirector gameDirector = new GameDirector(gameBoard);

        int carCount = 5;
        int roundSize = 10;

        //when
        gameDirector.playGame(carCount, roundSize);
        List<List<Integer>> records = gameBoard.readAllRecords();

        //then
        assertThat(readRowSize(records)).isEqualTo(roundSize);
        assertThat(readColumnSize(records)).isEqualTo(carCount);
    }

    private int readRowSize(List<List<Integer>> lists) {
        return lists.size();
    }

    private int readColumnSize(List<List<Integer>> lists) {
        return lists.get(FIRST_ROW_INDEX)
                .size();
    }
}
