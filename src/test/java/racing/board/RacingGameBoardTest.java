package racing.board;

import org.junit.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameBoardTest {

    @Test
    public void test_차_생성() {
        int size = 3;
        RacingGameBoard board = new RacingGameBoard();
        assertThat(board.createCars(size)).isEqualTo(size);
    }

    @Test
    public void test_모든_차가_이동가능한_보드() {
        RacingGameBoard board = new RacingGameBoard(() -> 10);
        board.createCars(5);
        board.moveCars();
        board.moveCars();;
        List<Integer> positions = board.moveCars();
        assertThat(positions).isEqualTo(Arrays.asList(3, 3, 3, 3, 3));
    }

    @Test
    public void test_모든_차가_이동불가능한_보드() {
        RacingGameBoard board = new RacingGameBoard(() -> 3);
        board.createCars(5);
        board.moveCars();
        board.moveCars();
        List<Integer> positions = board.moveCars();
        assertThat(positions).isEqualTo(Arrays.asList(0, 0, 0, 0, 0));
    }
}