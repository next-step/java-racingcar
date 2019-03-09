package racing.board;

import org.junit.*;
import racing.model.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameBoardTest {

    @Test
    public void test_차_생성() {
        int size = 3;
        RacingGameBoard board = new RacingGameBoard();
        board.createCars(size);
        assertThat(board.getCars().size()).isEqualTo(size);
    }

    @Test
    public void test_모든_차가_이동가능한_보드() {
        RacingGameBoard board = new RacingGameBoard(() -> 10);
        board.createCars(5);
        board.moveCars();
        board.moveCars();
        board.moveCars();

        for (RacingCar car : board.getCars()) {
            assertThat(car.getPosition()).isEqualTo(3);
        }
    }

    @Test
    public void test_모든_차가_이동불가능한_보드() {
        RacingGameBoard board = new RacingGameBoard(() -> 3);
        board.createCars(5);
        board.moveCars();

        for (RacingCar car : board.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    public void test_toString() {
        RacingGameBoard board = new RacingGameBoard(() -> 10);
        board.createCars(3);
        board.moveCars();
        assertThat(board.toString()).isEqualTo(
            "-\n" +
            "-\n" +
            "-\n"
        );
    }
}